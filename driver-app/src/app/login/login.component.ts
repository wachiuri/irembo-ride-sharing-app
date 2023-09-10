import { Component, inject } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  service: LoginService = inject(LoginService);
  router: Router = inject(Router);

  username: string = "";
  password: string = "";
  errorMessage: string = "";

  login() {
    this.errorMessage = "";
    this.service.login(this.username, this.password)
      .subscribe({
        next: response => {
          console.log(`response ${response}`);
          this.router.navigate(['/']);
        },
        error: (error: HttpErrorResponse) => {
          if (error.error.message) {
            this.errorMessage = error.error.message;
          }
          else {
            error.status === 401 ? this.errorMessage = "Invalid username or password" : this.errorMessage = error.message;
          }
        }
      })
      ;
  }

}
