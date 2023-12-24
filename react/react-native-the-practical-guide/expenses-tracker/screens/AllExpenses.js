import ExpensesOutput from "../components/ExpensesOutput/ExpensesOutput";
import useExpenses from "../store/useExpenses";

function AllExpenses() {
  const expensesContext = useExpenses();

  return (
    <ExpensesOutput
      periodName="Total"
      expenses={expensesContext.expenses}
      fallbackText="No registered expenses found!"
    />
  );
}

export default AllExpenses;
