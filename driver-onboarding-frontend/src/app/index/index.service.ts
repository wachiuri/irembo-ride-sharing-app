import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Driver } from './Driver';
import { Page } from '../lib/datatable/Page';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private httpClient: HttpClient = inject(HttpClient);

  constructor() { }

  public listDrivers(page: number, size: number): Observable<Page<Driver>> {
    return <Observable<Page<Driver>>>this.httpClient.get(`http://localhost:8090/driver?pageIndex=${page}&size=${size}`,
      {
        withCredentials: true,
        headers: {
          'Content-Type': 'application/json'
        }
      })
  }

  public saveDriver(driver: Driver): Observable<Driver> {
    return <Observable<Driver>>this.httpClient.post(`http://localhost:8090/driver`, driver,
      {
        withCredentials: true,
        headers: {
          'Content-Type': 'application/json'
        }
      });
  }

  public deleteDriver(id: number): Observable<Driver> {
    return <Observable<Driver>>this.httpClient.delete(`http://localhost:8090/driver/${id}`,
      {
        withCredentials: true,
        headers: {
          'Content-Type': 'application/json'
        }
      });
  }
}
