import { useContext } from "react";
import { ExpensesContext } from "./ExpensesContext";

export default function useExpenses() {
  const context = useContext(ExpensesContext);

  return context;
}
