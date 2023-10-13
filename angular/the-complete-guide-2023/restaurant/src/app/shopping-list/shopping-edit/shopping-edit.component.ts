import {
  Component,
  ElementRef,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { ShoppingListService } from '../shopping-list.service';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css'],
})
export class ShoppingEditComponent implements OnInit, OnDestroy {
  @ViewChild('form', { static: false }) form: NgForm;
  subscription: Subscription;
  editMode = false;
  editedItemIndex: number;

  constructor(private shoppingListService: ShoppingListService) {}
  handleSubmit() {
    if (this.editMode) {
      this.shoppingListService.updateIngredient(this.editedItemIndex, {
        name: this.form.value.name,
        amount: +this.form.value.amount,
      });
    } else
      this.shoppingListService.addIngredient({
        name: this.form.value.name,
        amount: +this.form.value.amount,
      });
    this.form.reset();
    this.editMode = false;
  }

  ngOnInit(): void {
    this.subscription = this.shoppingListService.startEditing.subscribe(
      (index) => {
        this.editMode = true;
        this.editedItemIndex = index;
        const ingredient = this.shoppingListService.getIngredient(index);
        this.form.setValue({
          name: ingredient.name,
          amount: ingredient.amount,
        });
      }
    );
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
  onDelete() {
    this.shoppingListService.deleteIngredient(this.editedItemIndex);
    this.resetForm();
  }
  resetForm() {
    this.form.reset();
    this.editMode = false;
  }
}
