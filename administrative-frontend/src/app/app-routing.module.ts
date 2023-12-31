import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { IndexComponent } from './index/index.component';
import { loginGuard } from './login/login.guard';
import { loggedInGuard } from './login/logged-in.guard';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
