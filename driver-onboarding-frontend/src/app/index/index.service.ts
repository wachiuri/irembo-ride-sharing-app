import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Driver } from './Driver';
import { Page } from '../lib/datatable/Page';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);

  public listDrivers(page: number, size: number): Observable<Page<User>> {
    return <Observable<Page<User>>>this.applicationHttpService.get(`/user/driver?pageIndex=${page}&size=${size}`)
  }

  public saveDriver(driver: User): Observable<User> {
    return <Observable<User>>this.applicationHttpService.post(`/driver`, driver);
  }

  public deleteDriver(id: number): Observable<Driver> {
    return <Observable<Driver>>this.applicationHttpService.delete(`/driver/${id}`);
  }
}
