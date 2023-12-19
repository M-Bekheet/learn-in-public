import { Text, View } from "react-native";
// import { useContext } from "react";
// import { FavoritesContext } from "../store/context/favorites-context";
import MealsList from "../components/MealsList/MealsList";
import { MEALS } from "../data/dummy-data";
import { StyleSheet } from "react-native";
import { useSelector } from "react-redux";

function FavoritesScreen() {
  // const { ids } = useContext(FavoritesContext);
  const ids = useSelector((state) => state.favoriteMeals.ids);
  const displayedMeals = MEALS.filter((meal) => ids.includes(meal.id));
  if (displayedMeals?.length === 0)
    return (
      <View style={styles.container}>
        <Text style={styles.text}>You have no favorite meals yet.</Text>
      </View>
    );
  return <MealsList items={displayedMeals} />;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  text: {
    fontSize: 18,
    fontWeight: "bold",
    color: "white",
  },
});

export default FavoritesScreen;
