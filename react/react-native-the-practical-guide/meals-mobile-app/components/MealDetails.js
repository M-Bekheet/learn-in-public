import { StyleSheet, Text, View } from "react-native";

export default function MealDetails({
  complexity,
  duration,
  affordability,
  style,
  textStyle,
}) {
  return (
    <View style={[styles.details, style]}>
      <Text style={[textStyle]}>{duration}m</Text>
      <Text style={[textStyle]}>{complexity.toUpperCase()}</Text>
      <Text style={[textStyle]}>{affordability.toUpperCase()}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  details: {
    flexDirection: "row",
    padding: 8,
    alignItems: "center",
    justifyContent: "center",
    gap: 8,
  },
});
