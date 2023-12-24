import { StyleSheet, Text, View } from "react-native";
import { GlobalStyles } from "../../constants/styles";
import ExpensesList from "./ExpensesList";
import ExpensesSummary from "./ExpensesSummary";

function ExpensesOutput({ periodName, expenses, fallbackText }) {
  let Content = <Text style={styles.infoText}>{fallbackText}</Text>;
  if (expenses.length > 0) {
    Content = <ExpensesList expenses={expenses} />;
  }
  return (
    <View style={styles.container}>
      <ExpensesSummary periodName={periodName} expenses={expenses} />
      {Content}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingHorizontal: 24,
    paddingTop: 24,
    backgroundColor: GlobalStyles.colors.primary700,
    color: "white",
  },
  infoText: {
    color: "white",
    fontSize: 16,
    textAlign: "center",
    marginTop: 32,
  },
});

export default ExpensesOutput;
