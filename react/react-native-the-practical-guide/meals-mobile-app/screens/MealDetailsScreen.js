import { useLayoutEffect } from "react";
import { Image, ScrollView, StyleSheet, Text, View } from "react-native";
import IconButton from "../components/IconButton";
import List from "../components/MealDetail/List";
import Subtitle from "../components/MealDetail/Subtitle";
import MealDetails from "../components/MealDetails";
import { MEALS } from "../data/dummy-data";
// import { FavoritesContext } from "../store/context/favorites-context";
import { useDispatch, useSelector } from "react-redux";
import { addFavorite, removeFavorite } from "../store/redux/favorites";

export default function MealDetailsScreen({ route, navigation }) {
  // const { addFavorite, removeFavorite, ids } = useContext(FavoritesContext);
  const ids = useSelector((state) => state.favoriteMeals.ids);
  const dispatch = useDispatch();

  const mealId = route.params.mealId;
  const meal = MEALS.find((meal) => meal.id === mealId);

  const mealIsFavorite = ids.includes(mealId);

  function changeFavoriteStatusHandler() {
    if (mealIsFavorite) dispatch(removeFavorite({ id: mealId }));
    else dispatch(addFavorite({ id: mealId }));
  }
  useLayoutEffect(() => {
    navigation.setOptions({
      headerRight: () => {
        return (
          <IconButton
            onPress={changeFavoriteStatusHandler}
            icon={mealIsFavorite ? "favorite" : "favorite-outline"}
            color="white"
          />
        );
      },
    });
  }, [mealIsFavorite]);

  return (
    <ScrollView style={styles.screen}>
      <Image source={{ uri: meal.imageUrl }} style={styles.image} />
      <Text style={styles.title}>Meal Details {meal.title} </Text>
      <MealDetails
        complexity={meal.complexity}
        duration={meal.duration}
        affordability={meal.affordability}
        style={styles.details}
        textStyle={styles.textStyle}
      />

      <View style={styles.listOuterContainer}>
        <View style={styles.listContainer}>
          <Subtitle>Ingredients</Subtitle>
          <List list={meal.ingredients} />
          <Subtitle>Steps</Subtitle>
          <List list={meal.steps} />
        </View>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  screen: {
    flex: 1,
    marginBottom: 32,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    margin: 8,
    color: "white",
    textAlign: "center",
  },
  image: {
    width: "100%",
    height: 350,
  },
  textStyle: {
    color: "white",
  },
  listOuterContainer: {
    alignItems: "center",
  },
  listContainer: {
    maxWidth: "80%",
  },
});
