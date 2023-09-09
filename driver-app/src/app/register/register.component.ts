import { Component, inject } from '@angular/core';
import { User } from '../index/User';
import { UserType } from '../index/UserType';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  private service: RegisterService = inject(RegisterService);

  driver: User = {
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    profilePicture: '',
    active: false,
    userType: UserType.DRIVER,
    rider: {
      id: 0
    },
    driver: {
      id: 0,
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

  register() {
    this.service.register(this.driver).subscribe();
  }
}
