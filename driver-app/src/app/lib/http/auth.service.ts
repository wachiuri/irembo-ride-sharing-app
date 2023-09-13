import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Config } from './Config';
import { BehaviorSubject, Observable, combineLatestWith, map, mergeMap } from 'rxjs';
import { Form } from '@angular/forms';
import { LoginResponse } from 'src/app/login/LoginResponse';
import { ApplicationHttpService } from './application-http.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private applicationHttpClient: ApplicationHttpService = inject(ApplicationHttpService);
  private httpClient: HttpClient = inject(HttpClient);

  public get(endPoint: string): Observable<any> {
    return this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.get(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), {
        headers: {
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public post(endPoint: string, data: any): Observable<any> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.post(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), data, {
        headers: {
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public login(endPoint: string, data: URLSearchParams): Observable<LoginResponse> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.post(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), data, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public postForm(endPoint: string, form: Form): Observable<any> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.post(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), form, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public postUrlEncodedForm(endPoint: string, form: URLSearchParams): Observable<any> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.post(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), form, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public delete(endPoint: string): Observable<any> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.delete(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }

  public put(endPoint: string, data: any): Observable<any> {
    return <Observable<LoginResponse>>this.applicationHttpClient.getLoginUrl().pipe(
      mergeMap((loginUrl) => this.httpClient.put(loginUrl + this.applicationHttpClient.normalizeEndpoint(endPoint), data, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${this.applicationHttpClient.getAccessToken()}`
        }
      })
      )
    );
  }
}
