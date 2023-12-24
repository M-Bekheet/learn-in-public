import { useEffect, useState } from "react";
import ExpensesOutput from "../components/ExpensesOutput/ExpensesOutput";
import useExpenses from "../store/useExpenses";
import { getDateMinusDays } from "../utils/date";
import { fetchExpenses } from "../utils/http";
import LoadingOverlay from "../components/UI/LoadingOverlay";
import ErrorOverlay from "../components/UI/ErrorOverlay";

function RecentExpenses() {
  const expensesContext = useExpenses();
  const [fetching, setFetching] = useState(true);
  const [error, setError] = useState();

  useEffect(() => {
    async function getExpenses() {
      try {
        const fetchedExpenses = await fetchExpenses();
        expensesContext.setExpenses(fetchedExpenses);
      } catch (err) {
        setError("Could not fetch expenses!");
      }
      setFetching(false);
    }
    getExpenses();
  }, []);

  const recentExpenses = expensesContext.expenses.filter((expense) => {
    const today = new Date();
    const date7DaysAgo = getDateMinusDays(today, 7);
    return expense.date >= date7DaysAgo && expense.date <= today;
  });

  if (error && !fetching) return <ErrorOverlay message={error} />;
  if (fetching) return <LoadingOverlay />;
  return (
    <ExpensesOutput
      expenses={recentExpenses}
      periodName="Last 7 Days"
      fallbackText="No expenses registered for the last 7 days."
    />
  );
}

export default RecentExpenses;
