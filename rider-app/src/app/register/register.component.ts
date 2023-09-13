import { Component, inject } from '@angular/core';
import { User } from '../index/User';
import { UserType } from '../index/UserType';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  private service: RegisterService = inject(RegisterService);
  private router: Router = inject(Router);

  rider: User = {
    id: null,
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phoneNumber: '',
    profilePicture: '',
    active: true,
    userType: UserType.RIDER,
    driver: null,
    rider: {
      id: null
    }
  };

  register() {
    this.service.register(this.rider)
      .subscribe(response => {
        this.router.navigate(['login']);
      });
  }


}
