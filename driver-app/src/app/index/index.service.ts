import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './Request';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { LoginService } from '../login/login.service';
import { User } from './User';
import { DriverLocation } from './DriverLocation';
import jwtDecode from 'jwt-decode';
import { DriverMatch } from './DriverMatch';
import { WebsocketService } from './websocket.service';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private loginService: LoginService = inject(LoginService);
  private websocketService: WebsocketService = inject(WebsocketService);

  list(): Observable<Request[]> {
    return this.applicationHttpService.get('/request');
  }

  accept(driverMatch: DriverMatch): Observable<Request[]> {
    this.websocketService;
    return <Observable<Request[]>>this.applicationHttpService.post("/request/accept", driverMatch);
  }

  reject(driverMatch: DriverMatch): Observable<Request[]> {
    this.websocketService;
    return <Observable<Request[]>>this.applicationHttpService.post("/request/reject", driverMatch);
  }

  update(lat: number, lng: number) {

    if (!lat && !lng) {
      return;
    }

    const decoded: any = jwtDecode(this.applicationHttpService.getAccessToken());

    const jsonData: string = decoded.data;

    const user = JSON.parse(jsonData);

    console.log('user', user)

    const driverLocation: DriverLocation = {
      user,
      lat,
      lng,
      cellAddress: ''
    }

    this.applicationHttpService.put('/driverLocation', driverLocation).subscribe();
    ;

  }

  generate(): Observable<void> {
    return this.applicationHttpService.post('/driverLocation/generate', {});
  }
}
