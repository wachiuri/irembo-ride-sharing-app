import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild, inject } from '@angular/core';
import { Observable, catchError, combineLatestWith, concatMap, concatWith, from, map, of } from 'rxjs';
import { IndexService } from './index.service';
import { DriverLocation } from './DriverLocation';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
import { WebsocketService, Message } from './websocket.service';
import { MapInfoWindow, MapMarker } from '@angular/google-maps';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import jwtDecode from 'jwt-decode';
import { DriverMatch, DriverMatchStage } from './DriverMatch';
import {v4 as uuidv4} from 'uuid';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  private httpClient: HttpClient = inject(HttpClient);
  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private service: IndexService = inject(IndexService);
  private loginService: LoginService = inject(LoginService);
  private router: Router = inject(Router);
  private websocketService: WebsocketService = inject(WebsocketService);

  apiLoaded!: Observable<boolean>;
  options: google.maps.MapOptions = {
    center: { lat: -1.9440727, lng: 30.0618851 },
    zoom: 10
  };
  markerOptions: google.maps.MarkerOptions = {
    draggable: false
  };
  markerPositions: google.maps.LatLng[] = [];
  drivers: Map<number, google.maps.LatLng> = new Map();
  driverLocations: Map<number, DriverLocation> = new Map();
  infoWindowText: string = '';

  @ViewChild('fromLocationInput') fromLocationInput: any;
  @ViewChild('toLocationInput') toLocationInput: any;

  fromLocation!: google.maps.LatLngLiteral;
  toLocation!: google.maps.LatLngLiteral;

  @ViewChild(MapInfoWindow) infoWindow: MapInfoWindow | undefined;

  matchedDriver?: DriverLocation;
  driverMatch?: DriverMatch;
  driverResponse: boolean | null = null;

  ngOnInit(): void {
    this.websocketService.messages.subscribe(msg => {
      console.log("Response from websocket: ", msg);
      switch (msg.source) {
        case 'driverLocation':
          const data = <DriverLocation>msg.data;
          this.driverLocations.set(data.user.driver!.id, data);

          if (data.user.driver!.id != null) {
            this.drivers.set(data.user.driver!.id, new google.maps.LatLng({
              lat: data.lat,
              lng: data.lng
            })
            );
          }

          console.log('this.drivers', this.drivers);

          this.markerPositions = [];
          this.drivers.forEach(a => this.markerPositions.push(a));

          break;
        case 'driverMatch':
          this.driverMatch = <DriverMatch>msg.data;
          console.log('this.driverMatch ', this.driverMatch);
          console.log('stage accept', this.driverMatch.stage.toString() === 'ACCEPT', 'reject', this.driverMatch.stage.toString() === 'REJECT')
          this.driverResponse = this.driverMatch.stage.toString() === 'ACCEPT' ? true : this.driverMatch.stage.toString() === 'REJECT' ? false : null;
          break;
      }
    });

    this.httpClient.jsonp('https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBFPD57hnSsdvhbC4_bjios8skFPqJxxl4', 'callback')
      .pipe(
        map(() => true)
      )
      .subscribe(a => {
        this.apiLoaded = of(a);
        const fromAutoComplete = new google.maps.places.Autocomplete(this.fromLocationInput.nativeElement);

        google.maps.event.addListener(fromAutoComplete, 'place_changed', () => {
          const fromPlace = fromAutoComplete.getPlace();
          if (fromPlace.geometry && fromPlace.geometry.location) {
            this.fromLocation = {
              lat: fromPlace.geometry?.location?.lat(),
              lng: fromPlace.geometry?.location?.lng()
            }
          }
        });

        const toAutoComplete = new google.maps.places.Autocomplete(this.toLocationInput.nativeElement);

        google.maps.event.addListener(toAutoComplete, 'place_changed', () => {
          const toPlace = toAutoComplete.getPlace();
          if (toPlace.geometry && toPlace.geometry.location) {
            this.toLocation = {
              lat: toPlace.geometry?.location?.lat(),
              lng: toPlace.geometry?.location?.lng()
            }
          }
        });
      });
  }

  openInfoWindow(index: number, mapMarker: MapMarker) {
    console.log('index', index);
    let i = 0;
    this.driverLocations.forEach((a, b) => {
      if (i === index) {
        this.infoWindowText = a.user.firstName + ' ' + a.user.lastName;
      }
      i++;
    });
    this.infoWindow?.open(mapMarker);
  }

  request() {
    this.showPath();
    this.match();
  }

  showPath() {
    if (!(this.fromLocation && this.toLocation)) {
      return;
    }
  }

  match() {
    if (!(this.fromLocation && this.toLocation)) {
      return;
    }

    const decoded: any = jwtDecode(this.applicationHttpService.getAccessToken());

    const user = JSON.parse(decoded.data);

    this.service.request({
      id: uuidv4(),
      user,
      departureLatitude: this.fromLocation.lat,
      departureLongitude: this.fromLocation.lng,
      arrivalLatitude: this.toLocation.lat,
      arrivalLongitude: this.toLocation.lng
    })
      .subscribe(a => this.matchedDriver = a);

  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['login']);
  }

}
