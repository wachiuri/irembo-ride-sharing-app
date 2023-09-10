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

  driver: User = {
    id: null,
    firstName: '',
    lastName: '',
    email: '',
    password:'',
    phoneNumber: '',
    profilePicture: '',
    active: false,
    userType: UserType.DRIVER,
    rider: null,
    driver: {
      id: null,
      address: '',
      licenseNumber: '',
      vehicleMake: '',
      vehicleModel: '',
      vehicleCc: '',
      yom: 0,
      vehicleColor: '',
      vehicleImage: ''
    }

  }

  errorMessage: string = '';
  successMessage: string = '';

  register() {
    this.successMessage = '';
    this.errorMessage = '';
    this.service.register(this.driver).subscribe(s => {
      this.successMessage = "Registration successfull. Kindly wait for admin approval";
      this.router.navigate(['login']);
    });
  }
}
