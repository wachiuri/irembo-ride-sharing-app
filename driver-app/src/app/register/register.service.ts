import { Injectable, inject } from '@angular/core';
import { ApplicationHttpService } from '../lib/http/application-http.service';
import { User } from '../index/User';
import { Observable } from 'rxjs';
import { AuthService } from '../lib/http/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private authService: AuthService = inject(AuthService);

  constructor() { }

  register(user: User): Observable<User> {
    return this.authService.post('/user/register', user);
  }
}
