import { Component, Input, OnInit } from '@angular/core';
import { Recipe } from '../recipe.model';
import { RecipeService } from '../recipes.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css'],
})
export class RecipeDetailComponent implements OnInit {
  recipe: Recipe;
  id: number;
  constructor(
    private recipeService: RecipeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.recipe = this.recipeService.getRecipe(params.id);
      this.id = params.id;
    });
  }

  addIngredientsToShoppingList() {
    this.recipeService.addToShoppingList(this.recipe);
  }

  onEditRecipe() {
    this.router.navigate(['edit'], {
      relativeTo: this.route,
    });
  }

  onDeleteRecipe() {
    this.recipeService.deleteRecipe(this.id);
    this.router.navigate(['/recipes']);
  }
}
