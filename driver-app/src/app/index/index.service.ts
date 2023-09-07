import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './Request';
import { ApplicationHttpService } from '../lib/http/application-http.service';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  private applicationHttpService: ApplicationHttpService = inject(ApplicationHttpService);

  constructor() { }

  list(): Observable<Request[]> {
    return this.applicationHttpService.get('/request');
  }

  accept(request: Request): Observable<Request[]> {
    return <Observable<Request[]>>this.applicationHttpService.post("/request", request);
  }
}
