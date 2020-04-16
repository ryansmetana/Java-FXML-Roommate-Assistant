package fxmlapp311;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ExpenseUICtrl implements Initializable {

    @FXML
    private TableView<Expense> expenseTable = new TableView<Expense>();
    @FXML
    private TableColumn<Expense, String> roommateColumn = new TableColumn("Roommate");
    @FXML
    private TableColumn<Expense, String> descriptionColumn = new TableColumn("Description");
    @FXML
    private TableColumn<Expense, Double> feeColumn = new TableColumn("Fee");
    @FXML
    private ObservableList<Expense> listOfExpenses;
    @FXML
    private Button createExpenseButton;
    @FXML
    private Button payExpenseButton;
    @FXML
    private Pane CreatePane;
    @FXML
    private TextField txtRoommate;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtFee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfExpenses = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData();

        // Set up the table columns and link them to the table data fields
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("description"));
        roommateColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("roommate"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Expense, Double>("fee"));

        // Add the data to the table
        expenseTable.setItems(listOfExpenses);
    }

    @FXML
    public void showCreatePane() {
        CreatePane.setVisible(true);
    }

    @FXML
    public void addRow(ActionEvent e) {
        CreatePane.setVisible(false);
        Expense tempExpense = new Expense(txtRoommate.getText(), txtDescription.getText(), Double.parseDouble(txtFee.getText()));
        Stage theStage = (Stage) payExpenseButton.getScene().getWindow();
        ExpenseCtrl.getExpenseCtrl(theStage).addExpenseRow(tempExpense);
        listOfExpenses = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData();
        expenseTable.setItems(listOfExpenses);
    }

    @FXML
    void payExpense(ActionEvent e) {
        
        Expense tempExpense = expenseTable.getSelectionModel().getSelectedItem();
        if (tempExpense == null){
            JOptionPane.showMessageDialog(null, "Please Select An Expense");
        }
        else{
            Stage theStage = (Stage) payExpenseButton.getScene().getWindow();
            ExpenseCtrl.getExpenseCtrl(theStage).deleteRow(tempExpense);
            listOfExpenses = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getExpenseList().getExpenseData();
            expenseTable.setItems(listOfExpenses);
            JOptionPane.showMessageDialog(null, "Thank you for paying");
        }
        

    }

    @FXML
    public void back() {
        Stage theStage = (Stage) payExpenseButton.getScene().getWindow();
        theStage.close();
        NavigationCntl navCtrl = NavigationCntl.getNavigationCntl(theStage);
        navCtrl.setUpNavigationScene();
    }

    @FXML
    public void openHelp() {
        JOptionPane.showMessageDialog(null, "Use the expense page to track different expenses\n"
                + "Press 'Create New Expense' to create an expense and assign it to a roommate\n"
                + "Select a task and press 'Pay Expense' to pay the expense");
    }

}
