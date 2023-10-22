import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RecipeService } from '../recipes/recipes.service';
import { Recipe } from '../recipes/recipe.model';
import { map, tap } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class DataStorageService {
  constructor(private http: HttpClient, private recipeService: RecipeService) {}

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
