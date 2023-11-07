import {
  Component,
  ComponentFactoryResolver,
  OnDestroy,
  ViewChild,
} from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthResponseData, AuthService } from './auth.service';
import { Observable, Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { AlertComponent } from '../alert/alert.component';
import { PlaceHolderDirective } from '../shared/placeholder/placeholder.directive';

@Component({
  selector: 'auth',
  templateUrl: './auth.component.html',
})
export class AuthComponent implements OnDestroy {
  isLoginMode = true;
  isLoading = false;
  error: string = null;
  @ViewChild(PlaceHolderDirective, { static: false })
  alertHost: PlaceHolderDirective;
  private closeSub: Subscription;

  constructor(
    private authService: AuthService,
    private router: Router,
    private componentFactoryResolver: ComponentFactoryResolver
  ) {}

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(form: NgForm) {
    const email = form.value.email;
    const password = form.value.password;
    this.isLoading = true;

    let authObs: Observable<AuthResponseData>;

    if (this.isLoginMode) {
      authObs = this.authService.login(email, password);
    } else {
      authObs = this.authService.signup(email, password);
    }
    authObs.subscribe(
      (res) => {
        console.log(res);
        this.isLoading = false;
        this.router.navigate(['/recipes']);
      },
      (errorMessage) => {
        // this.error = errorMessage;
        this.showErrorAlert(errorMessage);
        this.isLoading = false;
      }
    );

    form.reset();
  }

  private showErrorAlert(message: string) {
    const alertCompFactory =
      this.componentFactoryResolver.resolveComponentFactory(AlertComponent);
    const hostViewContainerRef = this.alertHost.viewContainerRef;
    hostViewContainerRef.clear();
    const componentRef = hostViewContainerRef.createComponent(alertCompFactory);

    componentRef.instance.message = message;

    this.closeSub = componentRef.instance.close.subscribe(() => {
      this.closeSub.unsubscribe;
      hostViewContainerRef.clear();
    });
  }

  handleClose() {
    this.error = null;
  }

  ngOnDestroy(): void {
    if (this.closeSub) {
      this.closeSub.unsubscribe();
    }
  }
}
