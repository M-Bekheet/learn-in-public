import { EventEmitter, Injectable } from '@angular/core';
import { Recipe } from './recipe.model';
import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from '../shopping-list/shopping-list.service';
import { Subject, Subscription } from 'rxjs';

@Injectable()
export class RecipeService {
  recipeChanged = new Subject<Recipe[]>();
  constructor(private shoppingListService: ShoppingListService) {}

  private recipes: Recipe[] = [];

  ngOnInit() {}

  setRecipes(recipes: Recipe[]) {
    this.recipes = recipes;
    this.recipeChanged.next(this.recipes.slice());
  }
  getRecipes() {
    return this.recipes.slice();
  }

  addToShoppingList(recipe: Recipe) {
    this.shoppingListService.addIngredients(recipe.ingredients);
  }
  getRecipe(index: number) {
    return this.recipes[index];
  }

  addRecipe(recipe: Recipe) {
    this.recipes.push(recipe);
    this.recipeChanged.next(this.getRecipes());
  }
  updateRecipe(index: number, newRecipe: Recipe) {
    this.recipes[index] = newRecipe;
    this.recipeChanged.next(this.getRecipes());
  }
  deleteRecipe(index: number) {
    this.recipes.splice(index, 1);
    this.recipeChanged.next(this.getRecipes());
  }
  deleteIngredient(recipeIndex: number, ingredientIndex: number) {
    this.recipes[recipeIndex].ingredients.splice(ingredientIndex, 1);
    this.recipeChanged.next(this.getRecipes());
  }
}
