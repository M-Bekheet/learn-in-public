import { EventEmitter } from '@angular/core';
import { Ingredient } from '../shared/ingredient.model';
import { Subject, Subscription } from 'rxjs';

export class ShoppingListService {
  ingredientsChange = new Subject<Ingredient[]>();
  startEditing = new Subject<number>();

  private ingredients: Ingredient[] = [
    new Ingredient('Apples', 5),
    new Ingredient('Tomatoes', 10),
  ];

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.ingredientsChange.next(this.getIngredients());
  }

  addIngredients(ingredients: Ingredient[]) {
    return this.ingredients.push(...ingredients.slice());
    this.ingredientsChange.next(this.getIngredients());
  }
  getIngredients() {
    return this.ingredients.slice();
  }

  getIngredient(index: number) {
    return this.ingredients[index];
  }

  updateIngredient(index: number, newIngredient) {
    this.ingredients[index] = newIngredient;
    this.ingredientsChange.next(this.getIngredients());
  }
  deleteIngredient(index: number) {
    this.ingredients.splice(index, 1);
    this.ingredientsChange.next(this.getIngredients());
  }
}
