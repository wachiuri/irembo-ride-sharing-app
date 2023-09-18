import { Component, ViewChild, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { IndexService } from './index.service';
import { DriverLocation } from './DriverLocation';
import { Request } from './Request';
import { Observable, catchError, combineLatest, combineLatestWith, map, of } from 'rxjs';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { Router } from '@angular/router';
import { WebsocketService } from './websocket.service';
import { DriverMatch, DriverMatchStage } from './DriverMatch';
import { MapDirectionsService } from '@angular/google-maps';
import { AuthService } from '../lib/http/auth.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent {
  private httpClient: HttpClient = inject(HttpClient);
  private service: IndexService = inject(IndexService);
  private authService: AuthService = inject(AuthService);
  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private router: Router = inject(Router);
  private websocketService: WebsocketService = inject(WebsocketService);

  apiLoaded!: Observable<boolean>;
  options: google.maps.MapOptions = {
    center: { lat: -1.9440727, lng: 30.0618851 },
    zoom: 10
  };
  markerOptions: google.maps.MarkerOptions = { draggable: false };
  markerPositions: google.maps.LatLng[] = [];
  directionsResults: Observable<google.maps.DirectionsResult | undefined> | undefined;
  mapDirectionsService: MapDirectionsService = inject(MapDirectionsService);

  request: Request | undefined;
  showRespondToDriverMatch: boolean = false;
  driverMatch: DriverMatch | null = null;

  @ViewChild('location') locationInput: any;

  location?: google.maps.LatLngLiteral;

  ngOnInit(): void {
    console.log("on init");
    this.httpClient.jsonp('https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBFPD57hnSsdvhbC4_bjios8skFPqJxxl4', 'callback')
      .pipe(
        map(() => true),
        catchError(() => of(false)),
      ).subscribe(a => {

        this.apiLoaded = of(a);

        const fromAutoComplete = new google.maps.places.Autocomplete(this.locationInput.nativeElement);

        google.maps.event.addListener(fromAutoComplete, 'place_changed', () => {
          const fromPlace = fromAutoComplete.getPlace();
          if (fromPlace.geometry && fromPlace.geometry.location) {
            this.location = {
              lat: fromPlace.geometry?.location?.lat(),
              lng: fromPlace.geometry?.location?.lng()
            }
          }
        });
      });

    this.service.list()
      .pipe(map((res: Request[]) => {
        const request: Request | undefined = res.length > 0 ? res.at(0) : undefined;
        if (request) {
          return {
            detination: {
              lat: request.arrivalLatitude,
              lng: request.arrivalLongitude
            },
            origin: {
              lat: request.departureLatitude,
              lng: request.departureLongitude
            }

          }
        }
        return undefined;
      }));

    this.websocketService.messages.subscribe(msg => {
      console.log("Response from websocket: ", msg);
      console.log('msg.source  ', msg.source);
      switch (msg.source) {
        /*case 'driverLocation':
          const data = <DriverLocation>msg.data;

          this.drivers.set(data.user.id, new google.maps.LatLng({
            lat: data.lat,
            lng: data.lng
          })
          );

          this.markerPositions = this.drivers.values();
          break;*/

        case 'driverMatch':
          console.log('driver match message');
          const driverMatch = <DriverMatch>msg.data;
          this.driverMatch = driverMatch;
          this.showRespondToDriverMatch = true;
          const request: google.maps.DirectionsRequest = {
            destination: { lat: driverMatch.request.arrivalLatitude, lng: driverMatch.request.arrivalLongitude },
            origin: { lat: driverMatch.request.departureLatitude, lng: driverMatch.request.departureLongitude },
            travelMode: google.maps.TravelMode.DRIVING
          };
          this.directionsResults = this.mapDirectionsService.route(request).pipe(map(response => response.result));
      }
    });
  }

  accept() {
    if (this.driverMatch) {
      this.driverMatch.stage = DriverMatchStage.ACCEPT;
      this.service.accept(this.driverMatch)
        .subscribe(r => this.showRespondToDriverMatch = false);
    }
  }

  reject() {
    if (this.driverMatch) {
      this.driverMatch.stage = DriverMatchStage.REJECT;
      this.service.reject(this.driverMatch)
        .subscribe(r => {
          this.driverMatch = null;
          this.showRespondToDriverMatch = false;
          this.directionsResults = undefined;
        });
    }
  }

  generate() {
    this.service.generate().subscribe();
  }

  update() {
    this.service.update(this.location!.lat, this.location!.lng);
  }

  logout() {
    localStorage.setItem('accessToken', '');
    this.applicationHttpService.setAccessToken('');
    this.router.navigate(['login']);
  }
}
