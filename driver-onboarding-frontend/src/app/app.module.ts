import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { IndexComponent } from './index/index.component';
import { LoginService } from './login/login.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { IndexService } from './index/index.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    LoginService,
    HttpClient,
    IndexService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
