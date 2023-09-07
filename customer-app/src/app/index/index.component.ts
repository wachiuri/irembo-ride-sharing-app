import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, ViewChild, inject } from '@angular/core';
import { OnInit } from '@angular/core';
import { Observable, catchError, combineLatestWith, concatMap, concatWith, from, map, of } from 'rxjs';
import { IndexService } from './index.service';
import { DriverLocation } from './DriverLocation';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit, AfterViewInit {

  private httpClient: HttpClient = inject(HttpClient);
  private service: IndexService = inject(IndexService);
  private loginService: LoginService = inject(LoginService);
  private router: Router = inject(Router);

  apiLoaded!: Observable<boolean>;
  options: google.maps.MapOptions = {
    center: { lat: -1.286389, lng: 36.817223 },
    zoom: 10
  };
  markerOptions: google.maps.MarkerOptions = { draggable: false };
  markerPositions: google.maps.LatLng[] = [];

  @ViewChild('fromLocationInput') fromLocationInput: any;
  @ViewChild('toLocationInput') toLocationInput: any;

  fromLocation!: google.maps.LatLngLiteral;
  toLocation!: google.maps.LatLngLiteral;

  matchedDriver?: DriverLocation;


  ngOnInit(): void {
    console.log("on init");
  }

  ngAfterViewInit(): void {
    this.httpClient.jsonp('https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBFPD57hnSsdvhbC4_bjios8skFPqJxxl4', 'callback')
      .pipe(
        map(() => true),
        combineLatestWith(this.service.list())
      )
      .subscribe(a => {
        this.apiLoaded = of(a[0]);
        console.log("driver locations ", a[1]);
        this.markerPositions = a[1].map(b => new google.maps.LatLng({
          lat: b.lat,
          lng: b.lng
        }));

        console.log("marker positions ", this.markerPositions);

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

    this.service.request({
      customerId: 1,
      name: "John Smith",
      phoneNumber: "+254720874935",
      email: "johnsmith@example.com",
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
