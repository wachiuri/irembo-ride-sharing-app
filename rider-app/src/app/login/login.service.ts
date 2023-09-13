import { Injectable, inject } from '@angular/core';
import { Observable, map, mergeMap } from 'rxjs';
import { Router, UrlTree } from '@angular/router';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { LoginResponse } from './LoginResponse';
import { HttpClient } from '@angular/common/http';
import jwtDecode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
  private httpClient: HttpClient = inject(HttpClient);
  private router = inject(Router);

  constructor() {
    const accessToken: string | null = localStorage.getItem('accessToken');
    console.log(`accessToken ${accessToken}`);

    if (accessToken != null) {
      this.applicationHttpService.setAccessToken(accessToken);
    }
    else {
      this.applicationHttpService.setAccessToken('');
    }
  }

  public login(username: string, password: string): Observable<any> {
    let data = new URLSearchParams();
    data.append('username', username);
    data.append('password', password);

    return this.applicationHttpService.login(
      data
    )
      .pipe(
        map(
          (response: LoginResponse) => {
            console.log('decoded token ', jwtDecode(response.token));
            localStorage.setItem('accessToken', response.token);
            this.applicationHttpService.setAccessToken(response.token);
          }
        )
      )
      ;
  }

  private normalizeEndpoint(endPoint: string): string {
    if (!endPoint.startsWith("/")) {
      endPoint = "/" + endPoint;
    }
    return endPoint;
  }

  public post(endPoint: string, data: any): Observable<any> {
    return this.applicationHttpService.getLoginUrl().pipe(
      mergeMap(loginUrl =>
        this.httpClient.post(loginUrl + this.normalizeEndpoint(endPoint), data)
      )

    );
  }

  logout() {
    localStorage.setItem('accessToken', '');
    this.applicationHttpService.setAccessToken('');
  }

  public canActivate(): boolean | UrlTree {
    return this.applicationHttpService.getAccessToken().length > 0 ? true : this.router.parseUrl("/login");
  }

  public isLoggedIn(): boolean | UrlTree {
    return this.applicationHttpService.getAccessToken().length > 0 ? this.router.parseUrl("/") : true;
  }
}