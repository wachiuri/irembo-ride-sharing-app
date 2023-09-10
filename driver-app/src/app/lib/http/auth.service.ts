import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Config } from './Config';
import { Observable } from 'rxjs';
import { Form } from '@angular/forms';
import { LoginResponse } from 'src/app/login/LoginResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private accessToken: string = '';
  private httpClient: HttpClient = inject(HttpClient);
  private serverUrl: string = 'http://localhost:8091';
  private loginUrl: string = 'http://localhost:8090';

  constructor() {
    this.httpClient.get("/assets/config.json").subscribe((data: any) => {
      const config = <Config>data;
      let loginUrl = config.loginUrl;
      if (loginUrl.endsWith("/")) {
        loginUrl = loginUrl.substring(0, loginUrl.length - 1);
      }
      this.loginUrl = loginUrl;
      console.log(`loginUrl ${loginUrl}`);
    });
  }

  public setAccessToken(accessToken: string): void {
    this.accessToken = accessToken;
  }

  public getAccessToken(): string {
    return this.accessToken;
  }

  private normalizeEndpoint(endPoint: string): string {
    if (!endPoint.startsWith("/")) {
      endPoint = "/" + endPoint;
    }
    return endPoint;
  }

  public get(endPoint: string): Observable<any> {
    return this.httpClient.get(this.loginUrl + this.normalizeEndpoint(endPoint), {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public post(endPoint: string, data: any): Observable<any> {
    return this.httpClient.post(this.loginUrl + this.normalizeEndpoint(endPoint), data, {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public login(endPoint: string, data: URLSearchParams): Observable<LoginResponse> {
    return this.httpClient.post<LoginResponse>(this.loginUrl + this.normalizeEndpoint(endPoint), data, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public postForm(endPoint: string, form: Form): Observable<any> {
    return this.httpClient.post(this.loginUrl + this.normalizeEndpoint(endPoint), form, {
      headers: {
        'Content-Type': 'multipart/form-data',
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public postUrlEncodedForm(endPoint: string, form: URLSearchParams): Observable<any> {
    return this.httpClient.post(this.loginUrl + this.normalizeEndpoint(endPoint), form, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public delete(endPoint: string): Observable<any> {
    return this.httpClient.delete(this.loginUrl + this.normalizeEndpoint(endPoint), {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public put(endPoint: string, data: any): Observable<any> {
    return this.httpClient.put(this.loginUrl + this.normalizeEndpoint(endPoint), data, {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }
}
