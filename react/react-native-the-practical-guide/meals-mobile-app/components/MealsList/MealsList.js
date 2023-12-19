import { StyleSheet, View, FlatList } from "react-native";
import MealItem from "./MealItem";

function MealsList({ items }) {
  function renderMealItem(itemData) {
    const item = itemData.item;
    const props = {
      imageUrl: item.imageUrl,
      title: item.title,
      complexity: item.complexity.toUpperCase(),
      affordability: item.affordability,
      duration: item.duration,
      mealId: item.id,
    };

    return <MealItem {...props} />;
  }
  return (
    <View style={styles.container}>
      <FlatList
        data={items}
        keyExtractor={(meal) => meal.id}
        renderItem={renderMealItem}
      />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
  },
});

export default MealsList;
