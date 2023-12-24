import { Alert, Text, View } from "react-native";
import Input from "./Input";
import { StyleSheet } from "react-native";
import { useState } from "react";
import Button from "../../components/UI/Button";
import { getFormattedDate } from "../../utils/date";
import { GlobalStyles } from "../../constants/styles";

function ExpenseForm({ defaultValues, submitButtonLabel, onCancel, onSubmit }) {
  const [amount, setAmount] = useState(defaultValues?.amount?.toString() || "");
  const [date, setDate] = useState(
    defaultValues?.date ? defaultValues.date.toISOString()?.slice(0, 10) : ""
  );
  const [formValid, setFormValid] = useState({
    amount: true,
    description: true,
    date: true,
  });
  const [description, setDescription] = useState(defaultValues?.description);
  const allValid = formValid.amount && formValid.description && formValid.date;
  function amountChangeHandler(newAmount) {
    setAmount(newAmount);
  }

  function dateChangeHandler(newDate) {
    setDate(newDate);
  }
  function descriptionChangeHandler(newDescription) {
    setDescription(newDescription);
  }

  function submitHandler() {
    const expense = {
      amount: parseInt(amount),
      date: new Date(date),
      description,
    };
    const { allValid, ...inputsValidity } = checkValidity(expense);
    setFormValid(inputsValidity);
    if (!checkValidity(expense).allValid) return;

    onSubmit(expense);
  }

  function checkValidity(expense) {
    const amount = !isNaN(expense.amount) && expense.amount > 0;
    const date = expense.date.toString() !== "Invalid Date";
    const description = expense.description?.trim()?.length > 0;
    return {
      allValid: amount && date && description,
      amount,
      date,
      description,
    };
  }

  return (
    <>
      <View style={styles.form}>
        <Text style={styles.title}>Your Expense</Text>
        <View style={styles.row}>
          <Input
            label="Amount"
            style={styles.rowInput}
            invalid={!formValid.amount}
            textInputConfig={{
              keyboardType: "decimal-pad",
              value: amount,
              onChangeText: amountChangeHandler,
            }}
          />
          <Input
            label="Date"
            invalid={!formValid.date}
            style={styles.rowInput}
            textInputConfig={{
              placeholder: "YYYY-MM-DD",
              maxLength: 10,
              value: date,
              onChangeText: dateChangeHandler,
            }}
          />
        </View>
        <Input
          label="Description"
          invalid={!formValid.description}
          style={styles.description}
          textInputConfig={{
            multiline: true,
            value: description,
            onChangeText: descriptionChangeHandler,
          }}
        />
        {!allValid && (
          <Text style={styles.error}>
            Invalid Input. Please check you input values
          </Text>
        )}
      </View>
      <View style={styles.buttons}>
        <Button style={styles.button} mode="flat" onPress={onCancel}>
          Cancel
        </Button>
        <Button style={styles.button} onPress={submitHandler}>
          {submitButtonLabel}
        </Button>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  form: {
    marginTop: 40,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    color: "white",
    marginVertical: 24,
    textAlign: "center",
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
  rowInput: {
    flex: 1,
  },
  buttons: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
  },
  button: {
    minWidth: 120,
    marginHorizontal: 8,
  },
  error: {
    margin: 8,
    fontSize: 18,
    color: GlobalStyles.colors.error500,
  },
  description: {
    maxHeight: 200,
    marginBottom: 30,
  },
});
export default ExpenseForm;
