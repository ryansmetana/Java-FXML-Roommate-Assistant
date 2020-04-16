package fxmlapp311;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExpenseList implements Serializable {

    private ObservableList<Expense> theListOfExpenses;
    private ArrayList<Expense> theListOfExpensesAL;

    public ExpenseList() {
        theListOfExpensesAL = getTestExpenses();
    }

    public ObservableList<Expense> getExpenseData() {
        ObservableList<Expense> theListOfExpenses;
        List<Expense> expenseList = (List<Expense>) theListOfExpensesAL;
        theListOfExpenses = FXCollections.observableList(expenseList);
        return theListOfExpenses;
    }

    public ArrayList<Expense> getTestExpenses() {
        ArrayList<Expense> testExpenses = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Expense newExpense = new Expense("Roommate" + i, "Description" + i, i);
            testExpenses.add(newExpense);
        }
        return testExpenses;
    }
}
