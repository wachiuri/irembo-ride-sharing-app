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

  list():Observable<Request[]>{
    return this.httpClient.get<Request[]>('http://localhost:8091/request');
  }
  
  accept(request:Request): Observable<Request[]> {
    return <Observable<Request[]>>this.httpClient.post("http://localhost:8091/request",request);
  }
}
