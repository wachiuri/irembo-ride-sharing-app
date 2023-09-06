import { Component, OnInit, inject } from '@angular/core';
import { Driver } from './Driver';
import { Page } from '../lib/datatable/Page';
import { IndexService } from './index.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  private service: IndexService = inject(IndexService);
  private modalService: NgbModal = inject(NgbModal);
  private modalRef!: NgbModalRef;
  driver!: Driver;
  deleteDriver!: Driver;
  drivers: Page<Driver> = {
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
      id: null,
      name: "",
      phoneNumber: "",
      email: "",
      address: "",
      licenseNumber: "",
      vehicleNumber: "",
      vehicleMake: "",
      vehicleModel: "",
      vehicleCc: "",
      yom: 0,
      vehicleColor: "",
      profilePicture: "",
      vehicleImage: ""
    };

    this.modalRef = this.modalService.open(formModal, {
      centered: true
    });
  }

  edit(driver: Driver, formModal: any) {
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


}
