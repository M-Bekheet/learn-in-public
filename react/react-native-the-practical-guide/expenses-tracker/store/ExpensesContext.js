import { createContext, useReducer } from "react";

export const ExpensesContext = createContext({
  expenses: [],
  addExpense: ({ description, amount, date }) => {},
  setExpenses: (expenses) => {},
  updateExpense: (id, { description, amount, date }) => {},
  deleteExpense: (id) => {},
});

function expensesReducer(state, action) {
  switch (action.type) {
    case "ADD":
      state = [...action.payload, ...state];
      return state;
    case "SET":
      return action.payload.reverse();
    case "UPDATE":
      const index = state.findIndex(
        (expense) => expense.id === action.payload.id
      );
      if (index > -1)
        state[index] = { ...state[index], ...action.payload.data };
      return [...state];

    case "DELETE":
      return state.filter((expense) => expense.id !== action.payload);

    default:
      return state;
  }
}

export default function ExpensesProvider({ children }) {
  const [expensesState, dispatch] = useReducer(expensesReducer, []);

  function deleteExpense(id) {
    dispatch({ type: "DELETE", payload: id });
  }

  function setExpenses(expenses) {
    dispatch({
      type: "SET",
      payload: expenses,
    });
  }

  function updateExpense(id, expenseData) {
    dispatch({ type: "UPDATE", payload: { id, data: expenseData } });
  }

  function addExpense(expenseData) {
    dispatch({ type: "ADD", payload: [expenseData] });
  }

  const value = {
    expenses: expensesState,
    addExpense,
    setExpenses,
    updateExpense,
    deleteExpense,
  };
  return (
    <ExpensesContext.Provider value={value}>
      {children}
    </ExpensesContext.Provider>
  );
}
