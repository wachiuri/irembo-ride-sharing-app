import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { loggedInGuard } from './login/logged-in.guard';
import { loginGuard } from './login/login.guard';

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
