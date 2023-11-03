import { Component, OnDestroy, OnInit } from '@angular/core';
import { DataStorageService } from '../shared/data-storage.service';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth/auth.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit, OnDestroy {
  isAuthenticated = false;
  collapsed = true;
  activeComponent = 'recipes';
  userSub: Subscription;

  constructor(
    private dataStorageService: DataStorageService,
    private userAuth: AuthService
  ) {}

  ngOnInit(): void {
    this.userSub = this.userAuth.user.subscribe((user) => {
      this.isAuthenticated = !!user;
      console.log(user);
    });
  }
  onSaveData() {
    this.dataStorageService.storeRecipes();
  }

  onFetchData() {
    this.dataStorageService.fetchRecipes().subscribe();
  }

  onLogout() {
    this.userAuth.logout();
  }

  ngOnDestroy() {
    this.userSub.unsubscribe();
  }
}
