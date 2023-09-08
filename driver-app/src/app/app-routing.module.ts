import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { loginGuard } from './login/login.guard';
import { LoginComponent } from './login/login.component';
import { loggedInGuard } from './login/logged-in.guard';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path: '',
    component: IndexComponent,
    canActivate: [loginGuard]
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [loggedInGuard]
  },
  {
    path: 'register',
    component: RegisterComponent,
    canActivate: [loggedInGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
