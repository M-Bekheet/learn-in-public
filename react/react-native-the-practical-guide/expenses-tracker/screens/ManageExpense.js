import { useLayoutEffect, useState } from "react";
import { StyleSheet, View } from "react-native";
import IconButton from "../components/UI/IconButton";
import { GlobalStyles } from "../constants/styles";
import useExpenses from "../store/useExpenses";
import ExpenseForm from "../components/ManageExpense/ExpenseForm";
import { deleteExpense, storeExpense, updateExpense } from "../utils/http";
import LoadingOverlay from "../components/UI/LoadingOverlay";
import ErrorOverlay from "../components/UI/ErrorOverlay";

function ManageExpense({ route, navigation }) {
  const [fetching, setFetching] = useState(false);
  const [error, setError] = useState();
  const expensesContext = useExpenses();
  const editedExpenseId = route.params?.expenseId;
  const isEditing = !!editedExpenseId;

  const defaultValues = isEditing
    ? expensesContext.expenses.find((expense) => expense.id === editedExpenseId)
    : {
        amount: "",
        date: "",
        description: "",
      };

  useLayoutEffect(() => {
    navigation.setOptions({
      title: isEditing ? "Edit Expense" : "Add Expense",
    });
  }, [navigation, isEditing]);

  async function deleteExpenseHandler() {
    setFetching(true);
    try {
      await deleteExpense(editedExpenseId);
      expensesContext.deleteExpense(editedExpenseId);
    } catch (err) {
      setError("Could not delete the expense - please try again later!");
      setFetching(false);
    }
    navigation.goBack();
  }
  async function confirmHandler(expenseData) {
    setFetching(true);
    if (isEditing) {
      try {
        expensesContext.updateExpense(editedExpenseId, expenseData);
        await updateExpense(editedExpenseId, expenseData);
        navigation.goBack();
      } catch (error) {
        setError("Could not update the expense - please try again later!");
        setFetching(false);
      }
    } else {
      try {
        const id = await storeExpense(expenseData);
        expensesContext.addExpense({ id, ...expenseData });
        navigation.goBack();
      } catch (error) {
        setError("Could not add the expense - please try again later!");
        setFetching(false);
      }
    }
  }
  function cancelHandler() {
    navigation.goBack();
  }

  if (error) return <ErrorOverlay message={error} />;
  if (fetching) return <LoadingOverlay />;

  return (
    <View style={styles.container}>
      <ExpenseForm
        submitButtonLabel={isEditing ? "Update" : "Add"}
        defaultValues={defaultValues}
        onCancel={cancelHandler}
        onSubmit={confirmHandler}
      />

      {isEditing && (
        <View style={styles.deleteContainer}>
          <IconButton
            icon="trash"
            color={GlobalStyles.colors.error500}
            size={36}
            onPress={deleteExpenseHandler}
          />
        </View>
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 24,
    backgroundColor: GlobalStyles.colors.primary700,
  },
  deleteContainer: {
    marginTop: 16,
    paddingTop: 8,
    borderTopWidth: 2,
    borderTopColor: GlobalStyles.colors.primary200,
    alignItems: "center",
  },
});
export default ManageExpense;
