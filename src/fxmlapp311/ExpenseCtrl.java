package fxmlapp311;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExpenseCtrl {

    private static ExpenseCtrl theExpenseCtrl;
    @FXML
    private Stage stage;
    private ObservableList<Expense> theListOfExpenses;

    private ExpenseCtrl(Stage theExistingStage) {
        theListOfExpenses = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData();
        stage = theExistingStage;
        setUpExpenseListScene();
        stage.show();
    }

    public static ExpenseCtrl getExpenseCtrl(Stage theStage) {
        if (theExpenseCtrl != null) {
            return theExpenseCtrl;
        } else {
            theExpenseCtrl = new ExpenseCtrl(theStage);
            return theExpenseCtrl;
        }
    }

    @FXML
    public void setUpExpenseListScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("ExpenseUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Expenses");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addExpenseRow(Expense newExpense) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData().add(newExpense);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public void deleteRow(Expense newExpense) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData().remove(newExpense);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public ObservableList<Expense> getListOfExpenses() {
        return theListOfExpenses;
    }
}
