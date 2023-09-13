import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Form } from '@angular/forms';
import { BehaviorSubject, Observable, mergeMap } from 'rxjs';
import { Config } from './Config';

@Injectable({
  providedIn: 'root'
})
export class ApplicationHttpService {

  private accessToken: string = '';
  private httpClient: HttpClient = inject(HttpClient);
  private serverUrl: BehaviorSubject<string> = new BehaviorSubject('http://localhost:8090');

  constructor() {
    this.httpClient.get("/assets/config.json").subscribe((data: any) => {
      const config = <Config>data;
      let serverUrl = config.serverUrl;
      if (serverUrl.endsWith("/")) {
        serverUrl = serverUrl.substring(0, serverUrl.length - 1);
      }
      this.serverUrl.next(serverUrl);
      console.log(`serverUrl ${serverUrl}`);
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
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.get(serverUrl + this.normalizeEndpoint(endPoint), {
          headers: {
            Authorization: `Bearer ${this.accessToken}`
          }
        })));
  }

  public post(endPoint: string, data: any): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), data, {
          headers: {
            Authorization: `Bearer ${this.accessToken}`
          }
        })));
  }

  public postForm(endPoint: string, form: Form): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), form, {
          headers: {
            'Content-Type': 'multipart/form-data',
            Authorization: `Bearer ${this.accessToken}`
          }
        })));
  }

  public postUrlEncodedForm(endPoint: string, form: URLSearchParams): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), form, {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            Authorization: `Bearer ${this.accessToken}`
          }
        })));
  }

  public delete(endPoint: string): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.delete(serverUrl + this.normalizeEndpoint(endPoint), {
          headers: {
            'Content-Type': 'multipart/form-data',
            Authorization: `Bearer ${this.accessToken}`
          }
        })));
  }
}
