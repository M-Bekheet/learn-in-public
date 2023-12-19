import { useLayoutEffect } from "react";
import MealsList from "../components/MealsList/MealsList";
import { CATEGORIES, MEALS } from "../data/dummy-data";

export default function MealsOverviewScreen({ route, navigation }) {
  const categoryId = route.params.categoryId;
  const displayedMeals = MEALS.filter(
    (meal) => meal.categoryIds.indexOf(categoryId) >= 0
  );
  const category = CATEGORIES.find((cat) => cat.id === categoryId);

  useLayoutEffect(() => {
    navigation.setOptions({
      title: category.title,
    });
  }, [category, navigation]);

  return <MealsList items={displayedMeals} />;
}
