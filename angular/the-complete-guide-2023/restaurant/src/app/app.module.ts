import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRouter } from './app-router.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import { RecipeEditComponent } from './recipes/recipe-edit/recipe-edit.component';
import { RecipeItemComponent } from './recipes/recipe-item/recipe-item.component';
import { RecipeListComponent } from './recipes/recipe-list/recipe-list.component';
import { RecipeStartComponent } from './recipes/recipe-start/recipe-start.component';
import { RecipesComponent } from './recipes/recipes.component';
import { RecipeService } from './recipes/recipes.service';
import { DropdownDirective } from './shared/dropdown.directive';
import { ShoppingEditComponent } from './shopping-list/shopping-edit/shopping-edit.component';
import { ShoppingListComponent } from './shopping-list/shopping-list.component';
import { ShoppingListService } from './shopping-list/shopping-list.service';
import { HttpClientModule } from '@angular/common/http';
import { AuthComponent } from './auth/auth.component';
import { LoadingSpinnerComponent } from './shared/loading-spinner/loading-spinner.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RecipesComponent,
    RecipeListComponent,
    ShoppingListComponent,
    ShoppingEditComponent,
    RecipeDetailComponent,
    RecipeItemComponent,
    DropdownDirective,
    RecipeStartComponent,
    RecipeEditComponent,
    AuthComponent,
    LoadingSpinnerComponent,
  ],
  imports: [
    BrowserModule,
    AppRouter,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [ShoppingListService, RecipeService],
  bootstrap: [AppComponent],
})
export class AppModule {}
