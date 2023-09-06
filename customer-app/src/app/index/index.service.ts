import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DriverLocation } from './DriverLocation';
import { Observable } from 'rxjs';
import { Request } from './Request';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private httpClient: HttpClient = inject(HttpClient);

  constructor() { }

  list(): Observable<DriverLocation[]> {
    return <Observable<DriverLocation[]>>this.httpClient.get("http://localhost:8091/driverLocation");
  }

  request(request: Request): Observable<DriverLocation> {
    return <Observable<DriverLocation>>this.httpClient.post("http://localhost:8091/request", request);
  }
}
