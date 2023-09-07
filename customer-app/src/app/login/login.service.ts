import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Router, UrlTree } from '@angular/router';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { LoginResponse } from './LoginResponse';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);
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
            localStorage.setItem('accessToken', response.token);
            this.applicationHttpService.setAccessToken(response.token);
          }
        )
      )
      ;
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