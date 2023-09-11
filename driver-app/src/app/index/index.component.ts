import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { IndexService } from './index.service';
import { DriverLocation } from './DriverLocation';
import { Request } from './Request';
import { Observable, catchError, combineLatest, combineLatestWith, map, of } from 'rxjs';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { Router } from '@angular/router';
import { WebsocketService } from './websocket.service';
import { DriverMatch } from './DriverMatch';
import { MapDirectionsService } from '@angular/google-maps';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent {
  private httpClient: HttpClient = inject(HttpClient);
  private service: IndexService = inject(IndexService);
  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private router: Router = inject(Router);
  private websocketService: WebsocketService = inject(WebsocketService);

  apiLoaded!: Observable<boolean>;
  options: google.maps.MapOptions = {
    center: { lat: -1.286389, lng: 36.817223 },
    zoom: 10
  };
  markerOptions: google.maps.MarkerOptions = { draggable: false };
  markerPositions: google.maps.LatLng[] = [];
  directionsResults: Observable<google.maps.DirectionsResult | undefined> | undefined;
  mapDirectionsService: MapDirectionsService = inject(MapDirectionsService);

  request: Request | undefined;

  ngOnInit(): void {
    console.log("on init");
    this.apiLoaded = this.httpClient.jsonp('https://maps.googleapis.com/maps/api/js?key=AIzaSyBFPD57hnSsdvhbC4_bjios8skFPqJxxl4', 'callback')
      .pipe(
        map(() => true),
        catchError(() => of(false)),
      );

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
          const driverMatch = <DriverMatch>msg.data;
          const request: google.maps.DirectionsRequest = {
            destination: { lat: driverMatch.request.arrivalLatitude, lng: driverMatch.request.arrivalLongitude },
            origin: { lat: driverMatch.request.departureLatitude, lng: driverMatch.request.departureLongitude },
            travelMode: google.maps.TravelMode.DRIVING
          };
          this.directionsResults = this.mapDirectionsService.route(request).pipe(map(response => response.result));
          break;
      }
    })

  }

  accept() {
    if (this.request) {
      this.service.accept(this.request)
        .pipe(
          combineLatestWith(this.service.list()),
        ).subscribe();
    }
  }

  update() {
    this.service.update();
  }

  logout() {
    localStorage.setItem('accessToken', '');
    this.applicationHttpService.setAccessToken('');
    this.router.navigate(['login']);
  }
}
