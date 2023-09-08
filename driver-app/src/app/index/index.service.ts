import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './Request';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { LoginService } from '../login/login.service';
import { User } from './User';
import { DriverLocation } from './DriverLocation';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private loginService: LoginService = inject(LoginService);

  constructor() { }

  list(): Observable<Request[]> {
    return this.applicationHttpService.get('/request');
  }

  accept(request: Request): Observable<Request[]> {
    return <Observable<Request[]>>this.applicationHttpService.post("/request", request);
  }

  update() {
    const currentUser: User = this.loginService.getCurrentUser();
    if (currentUser) {
      const driverLocation:DriverLocation = {
        user: currentUser,
        lat: -1.3278078,
        lng: 36.8815573,
        cellAddress: ''
      };

      this.applicationHttpService.put('/driverLocation', driverLocation).subscribe();
    }
  }
}
