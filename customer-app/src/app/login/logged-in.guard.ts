import { CanActivateFn } from '@angular/router';
import { LoginService } from './login.service';
import { inject } from '@angular/core';

export const loggedInGuard: CanActivateFn = (route, state) => {
  return inject(LoginService).isLoggedIn();
};
