import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Form } from '@angular/forms';
import { BehaviorSubject, Observable, combineLatestWith, map, mergeMap } from 'rxjs';
import { Config } from './Config';
import { LoginResponse } from 'src/app/login/LoginResponse';

@Injectable({
  providedIn: 'root'
})
export class ApplicationHttpService {

  private accessToken: string = '';
  private httpClient: HttpClient = inject(HttpClient);
  private serverUrl: BehaviorSubject<string> = new BehaviorSubject('http://localhost:8092');
  private loginUrl: BehaviorSubject<string> = new BehaviorSubject('http://localhost:8090');
  private websocketUrl: BehaviorSubject<string> = new BehaviorSubject('ws://localhost:8092/websocket');

  constructor() {
    this.httpClient.get("/assets/config.json").subscribe((data: any) => {
      const config = <Config>data;
      this.serverUrl.next(this.normalizeUrl(config.serverUrl));
      this.loginUrl.next(this.normalizeUrl(config.loginUrl));
      this.websocketUrl.next(this.normalizeUrl(config.websocketUrl));
    });
  }

  public setAccessToken(accessToken: string): void {
    this.accessToken = accessToken;
  }

  public getAccessToken(): string {
    return this.accessToken;
  }

  public getWebsocketUrl(): Observable<string> {
    return this.websocketUrl;
  }

  public getLoginUrl(): Observable<string> {
    return this.loginUrl;
  }

  private normalizeUrl(url: string): string {
    if (url.endsWith("/")) {
      url = url.substring(0, url.length - 1);
    }
    return url;
  }

  public normalizeEndpoint(endPoint: string): string {
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
        }))
      );
  }

  public post(endPoint: string, data: any): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), data, {
          headers: {
            Authorization: `Bearer ${this.accessToken}`
          }
        }))
      );
  }

  public postForm(endPoint: string, form: Form): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), form, {
          headers: {
            'Content-Type': 'multipart/form-data',
            Authorization: `Bearer ${this.accessToken}`
          }
        }))
      );
  }

  public postUrlEncodedForm(endPoint: string, form: URLSearchParams): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.post(serverUrl + this.normalizeEndpoint(endPoint), form, {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            Authorization: `Bearer ${this.accessToken}`
          }
        }))
      );
  }

  public delete(endPoint: string): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.delete(serverUrl + this.normalizeEndpoint(endPoint), {
          headers: {
            Authorization: `Bearer ${this.accessToken}`
          }
        }))
      );
  }

  public put(endPoint: string, data: any): Observable<any> {
    return this.serverUrl
      .pipe(
        mergeMap(serverUrl => this.httpClient.put(serverUrl + this.normalizeEndpoint(endPoint), data, {
          headers: {
            Authorization: `Bearer ${this.accessToken}`
          }
        }))
      );
  }
}
