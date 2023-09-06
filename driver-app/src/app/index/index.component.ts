import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { IndexService } from './index.service';
import { DriverLocation } from './DriverLocation';
import { Request } from './Request';
import { Observable, catchError, combineLatest, combineLatestWith, map, of } from 'rxjs';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent {
  private httpClient: HttpClient = inject(HttpClient);
  private service: IndexService = inject(IndexService);

  apiLoaded!: Observable<boolean>;
  options: google.maps.MapOptions = {
    center: { lat: -1.286389, lng: 36.817223 },
    zoom: 10
  };
  markerOptions: google.maps.MarkerOptions = { draggable: false };
  markerPositions: google.maps.LatLng[] = [];
  directionsResults$: Observable<google.maps.DirectionsResult | undefined> | undefined;

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

  }

  accept() {
    if(this.request){
      this.service.accept(this.request)
      .pipe(
        combineLatestWith(this.service.list()),
      ).subscribe();
    }
  }
}
