import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { ApplicationHttpService } from './lib/http/application-http.service';
import { IndexService } from './index/index.service';
import { FormsModule } from '@angular/forms';
import { WebsocketService } from './index/websocket.service';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './register/register.service';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent
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
    ApplicationHttpService,
    IndexService,
    WebsocketService,
    RegisterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
