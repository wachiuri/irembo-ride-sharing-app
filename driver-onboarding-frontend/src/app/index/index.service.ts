import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Driver } from './Driver';
import { Page } from '../lib/datatable/Page';
import { ApplicationHttpService } from '../lib/http/application-http.service';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);

  public listDrivers(page: number, size: number): Observable<Page<Driver>> {
    return <Observable<Page<Driver>>>this.applicationHttpService.get(`/driver?pageIndex=${page}&size=${size}`)
  }

  public saveDriver(driver: Driver): Observable<Driver> {
    return <Observable<Driver>>this.applicationHttpService.post(`/driver`, driver);
  }

  public deleteDriver(id: number): Observable<Driver> {
    return <Observable<Driver>>this.applicationHttpService.delete(`/driver/${id}`);
  }
}
