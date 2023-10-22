import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment.development';
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
  constructor(private http: HttpClient) {}

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
      .pipe(catchError(this.handleError));
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
      .pipe(catchError(this.handleError));
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
