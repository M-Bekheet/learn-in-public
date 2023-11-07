import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, switchMap, take, tap } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { AuthService } from '../auth/auth.service';
import { Recipe } from '../recipes/recipe.model';
import { RecipeService } from '../recipes/recipes.service';

@Injectable({
  providedIn: 'root',
})
export class DataStorageService {
  constructor(
    private http: HttpClient,
    private recipeService: RecipeService,
    private authService: AuthService
  ) {}

  storeRecipes() {
    const recipes = this.recipeService.getRecipes();
    this.http.put(environment.url, recipes).subscribe((response) => {
      console.log(response);
    });
  }

  fetchRecipes() {
    return this.http.get<Recipe[]>(environment.url).pipe(
      map((recipes) =>
        recipes.map((recipe) => {
          if (!recipe.ingredients) recipe.ingredients = [];
          return recipe;
        })
      ),
      tap((recipes) => {
        console.log(recipes);
        this.recipeService.setRecipes(recipes);
      })
    );
  }
}
