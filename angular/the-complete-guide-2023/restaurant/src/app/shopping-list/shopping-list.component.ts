import { Component, OnDestroy, OnInit } from '@angular/core';
import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from './shopping-list.service';
import { Subscription } from 'rxjs';
import { LoggingService } from '../logging.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css'],
  providers: [],
})
export class ShoppingListComponent implements OnInit, OnDestroy {
  ingredients: Ingredient[] = [];
  igSubscription: Subscription;

  constructor(
    private shoppingService: ShoppingListService,
    private loggingService: LoggingService
  ) {}

  onEditItem(index: number) {
    this.shoppingService.startEditing.next(index);
  }
  ngOnInit() {
    this.ingredients = this.shoppingService.getIngredients();
    this.igSubscription = this.shoppingService.ingredientsChange.subscribe(
      (ingredients) => (this.ingredients = ingredients)
    );
    this.loggingService.printLog('Hello from ShoppingList Component');
  }

  ngOnDestroy(): void {
    this.igSubscription.unsubscribe();
  }
}
