import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Form } from '@angular/forms';
import { Observable } from 'rxjs';
import { Config } from './Config';
import { LoginResponse } from 'src/app/login/LoginResponse';

@Injectable({
  providedIn: 'root'
})
export class ApplicationHttpService {

  private accessToken: string = '';
  private httpClient: HttpClient = inject(HttpClient);
  private serverUrl: string = 'http://localhost:8092';
  private loginUrl: string = 'http://localhost:8090';
  private websocketUrl: string = 'ws://localhost:8092/websocket';

  constructor() {
    this.httpClient.get("/assets/config.json").subscribe((data: any) => {
      const config = <Config>data;
      let serverUrl = config.serverUrl;
      if (serverUrl.endsWith("/")) {
        serverUrl = serverUrl.substring(0, serverUrl.length - 1);
      }
      this.serverUrl = serverUrl;
      console.log(`serverUrl ${serverUrl}`);
    });
  }

  public setAccessToken(accessToken: string): void {
    this.accessToken = accessToken;
  }

  public getAccessToken(): string {
    return this.accessToken;
  }

  public getWebsocketUrl(): string {
    return this.websocketUrl;
  }

  private normalizeEndpoint(endPoint: string): string {
    if (!endPoint.startsWith("/")) {
      endPoint = "/" + endPoint;
    }
    return endPoint;
  }

  public get(endPoint: string): Observable<any> {
    return this.httpClient.get(this.serverUrl + this.normalizeEndpoint(endPoint), {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public post(endPoint: string, data: any): Observable<any> {
    return this.httpClient.post(this.serverUrl + this.normalizeEndpoint(endPoint), data, {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public postForm(endPoint: string, form: Form): Observable<any> {
    return this.httpClient.post(this.serverUrl + this.normalizeEndpoint(endPoint), form, {
      headers: {
        'Content-Type': 'multipart/form-data',
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public postUrlEncodedForm(endPoint: string, form: URLSearchParams): Observable<any> {
    return this.httpClient.post(this.serverUrl + this.normalizeEndpoint(endPoint), form, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public delete(endPoint: string): Observable<any> {
    return this.httpClient.delete(this.serverUrl + this.normalizeEndpoint(endPoint), {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }

  public put(endPoint: string, data: any): Observable<any> {
    return this.httpClient.put(this.serverUrl + this.normalizeEndpoint(endPoint), data, {
      headers: {
        Authorization: `Bearer ${this.accessToken}`
      }
    });
  }
}
