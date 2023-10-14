import {
  HttpEventType,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { tap } from 'rxjs/operators';

export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const modifiedRequest = req.clone({
      headers: req.headers.append('Auth', 'Sure, why not'),
    });
    console.log('Request is on its way...');
    return next.handle(modifiedRequest).pipe(
      tap((event) => {
        console.log(req.method);
        console.log(event);
        if (event.type === HttpEventType.Response) {
          console.log('Response Arrived');
          console.log(event.body);
        }
      })
    );
  }
}
