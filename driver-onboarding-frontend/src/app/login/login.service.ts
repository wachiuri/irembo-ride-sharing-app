import { Injectable, inject } from '@angular/core';
import { Observable, BehaviorSubject, map } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  private httpClient = inject(HttpClient);
  private router = inject(Router);

  constructor() { }

  public login(username: string, password: string): Observable<any> {
    let data = new URLSearchParams();
    data.append('username', username);
    data.append('password', password);

    return this.httpClient.post(
      'http://localhost:8090/login', 
      data,
      {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }
      )
      .pipe(map(response => {
        this.loggedIn.next(true);
        return response;
      }))
      ;
  }

  public isLoggedIn(): Observable<boolean> {
    return this.loggedIn;
  }

  public canActivate(): Observable<boolean | UrlTree> {
    return this.isLoggedIn().pipe(map(isLoggedIn => {
      return isLoggedIn ? true : this.router.parseUrl("/login")
    }));
  }
}
