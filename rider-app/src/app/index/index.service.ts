import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DriverLocation } from './DriverLocation';
import { Observable } from 'rxjs';
import { Request } from './Request';
import { ApplicationHttpService } from '../lib/http/application-http.service';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);

  constructor() { }

  list(): Observable<DriverLocation[]> {
    return <Observable<DriverLocation[]>>this.applicationHttpService.get("/driverLocation");
  }

  request(request: Request): Observable<DriverLocation> {
    return <Observable<DriverLocation>>this.applicationHttpService.post("/request", request);
  }
}
