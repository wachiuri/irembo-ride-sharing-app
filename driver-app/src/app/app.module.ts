import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { HttpClient, HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from './login/login.service';
import { IndexService } from './index/index.service';
import { ApplicationHttpService } from './lib/http/application-http.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GoogleMapsModule,
    HttpClientModule,
    HttpClientJsonpModule,
    CommonModule,
    NgbModule,
    FormsModule
  ],
  providers: [
    LoginService,
    IndexService,
    HttpClient,
    IndexService,
    ApplicationHttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
