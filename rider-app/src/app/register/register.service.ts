import { Injectable, inject } from '@angular/core';
import { User } from '../index/User';
import { Observable } from 'rxjs';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private loginService: LoginService = inject(LoginService);

  register(user:User):Observable<User> {
    return this.loginService.post("/user/register", user);
  }
}
