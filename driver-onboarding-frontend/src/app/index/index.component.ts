import { Component, OnInit, inject } from '@angular/core';
import { Driver } from './Driver';
import { Page } from '../lib/datatable/Page';
import { IndexService } from './index.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from './User';
import { UserType } from './UserType';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  private router: Router = inject(Router);
  private service: IndexService = inject(IndexService);
  private loginService: LoginService = inject(LoginService);
  private modalService: NgbModal = inject(NgbModal);
  private modalRef!: NgbModalRef;
  driver!: User;
  deleteDriver!: User;
  drivers: Page<User> = {
    content: [],
    totalElements: 0,
    totalPages: 0,
    size: 0
  };

  page: number = 1;
  size: number = 10;

  errorMessage: string = "";

  ngOnInit(): void {
    this.refresh();
  }

  refresh() {
    this.service.listDrivers(this.page, this.size).subscribe(response => this.drivers = response);
  }

  submitDelete() {
    this.service.deleteDriver(<number>this.deleteDriver.id).subscribe(response => {
      this.refresh();
      this.modalRef.close();
    });
  }

  delete(deleteModal: any) {
    this.modalRef = this.modalService.open(deleteModal, {
      centered: true
    });
  }

  newDriver(formModal: any) {
    this.driver = {
      id: undefined,
      firstName: "",
      lastName: "",
      phoneNumber: "",
      email: "",
      profilePicture: "",
      active: true,
      userType: UserType.DRIVER,
      driver: {
        id: undefined,
        address: "",
        licenseNumber: "",
        vehicleMake: "",
        vehicleModel: "",
        vehicleCc: "",
        yom: 0,
        vehicleColor: "",
        vehicleImage: "",
      },
      rider: undefined
    };

    this.modalRef = this.modalService.open(formModal, {
      centered: true
    });
  }

  edit(driver: User, formModal: any) {
    this.driver = driver;

    this.modalRef = this.modalService.open(formModal, {
      centered: true
    });
  }

  save() {
    this.service.saveDriver(this.driver)
      .subscribe({
        next: response => {
          this.refresh();
          this.modalRef.close();
        },
        error: error => {
          this.errorMessage = error.message;
        }
      })
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['login']);
  }


}
