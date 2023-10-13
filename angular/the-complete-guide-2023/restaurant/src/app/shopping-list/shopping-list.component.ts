import { Component, OnDestroy, OnInit } from '@angular/core';
import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from './shopping-list.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css'],
  providers: [],
})
export class ShoppingListComponent implements OnInit, OnDestroy {
  ingredients: Ingredient[] = [];
  igSubscription: Subscription;

  constructor(private shoppingService: ShoppingListService) {}

  onEditItem(index: number) {
    this.shoppingService.startEditing.next(index);
  }
  ngOnInit() {
    this.ingredients = this.shoppingService.getIngredients();
    this.igSubscription = this.shoppingService.ingredientsChange.subscribe(
      (ingredients) => (this.ingredients = ingredients)
    );
  }

  ngOnDestroy(): void {
    this.igSubscription.unsubscribe();
  }
}
