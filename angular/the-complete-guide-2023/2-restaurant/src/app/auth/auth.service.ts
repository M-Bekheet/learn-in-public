import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment.development';
import { User } from './user.model';
export interface AuthResponseData {
  kind: string;
  idToken: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string;
  registered?: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  user = new BehaviorSubject<User>(null);
  tokenExpirationTimer = <number | null>null;
  constructor(private http: HttpClient, private router: Router) {}
  login(email: string, password: string) {
    return this.http
      .post<AuthResponseData>(
        'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=' +
          environment.apiKey,
        {
          email,
          password,
          returnSecureToken: true,
        }
      )
      .pipe(
        catchError(this.handleError),
        tap((res) => {
          this.handleAuthentication(
            res.email,
            res.localId,
            res.idToken,
            +res.expiresIn
          );
        })
      );
  }

  autoLogin() {
    const storedUser = <
      {
        email: string;
        id: string;
        _token: string;
        _tokenExpirationDate: string;
      }
    >JSON.parse(localStorage.getItem('userData'));
    if (!storedUser) return;

    const user = new User(
      storedUser.email,
      storedUser.id,
      storedUser._token,
      new Date(storedUser._tokenExpirationDate)
    );
    if (user.token) {
      this.user.next(user);
      const expirationDuration =
        new Date(storedUser._tokenExpirationDate).getTime() -
        new Date().getTime();

      this.autoLogout(expirationDuration);
    }
  }

  signup(email: string, password: string) {
    return this.http
      .post<AuthResponseData>(
        'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=' +
          environment.apiKey,
        {
          email,
          password,
          returnSecureToken: true,
        }
      )
      .pipe(
        catchError(this.handleError),
        tap((res) => {
          this.handleAuthentication(
            res.email,
            res.localId,
            res.idToken,
            +res.expiresIn
          );
        })
      );
  }

  logout() {
    this.user.next(null);
    this.router.navigate(['/auth']);
    localStorage.removeItem('userData');
    this.tokenExpirationTimer = null;
  }

  autoLogout(expirationDuration: number) {
    console.log(expirationDuration);
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
  }

  private handleAuthentication(
    email: string,
    userId: string,
    token: string,
    expiresIn: number
  ) {
    const expirationData = new Date(new Date().getTime() + +expiresIn * 1000);
    const user = new User(email, userId, token, expirationData);
    localStorage.setItem('userData', JSON.stringify(user));
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
  }

  private handleError(errRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    if (!errRes.error || !errRes.error.error) {
      return throwError(errorMessage);
    }
    switch (errRes.error.error.message) {
      case 'EMAIL_EXISTS':
        errorMessage = 'This email exists already';
        break;
      case 'EMAIL_NOT_FOUND':
        errorMessage = 'Email not found';
        break;
      case 'INVALID_PASSWORD':
        errorMessage = 'Your password is incorrect';
        break;
      case 'USER_DISABLED':
        errorMessage = 'This account has been deactivated';
        break;
      case 'INVALID_LOGIN_CREDENTIALS':
        errorMessage = 'Email or password is not correct';
        break;
    }
    return throwError(errorMessage);
  }
}
