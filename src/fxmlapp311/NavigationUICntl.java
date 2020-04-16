package fxmlapp311;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NavigationUICntl {

    @FXML
    private Text actiontarget;
    @FXML
    private Stage stage;

    @FXML
    protected void handleExitButtonAction(ActionEvent event) {
        actiontarget.setText("Exit button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        NavigationCntl.getNavigationCntl(theStage).exit();
    }

    @FXML
    protected void handleUsersButtonAction(ActionEvent event) {
        actiontarget.setText("Users button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.close();
        UserCntl userCtrl = UserCntl.getUserCntl(theStage);
        userCtrl.setUpUserListScene();
    }

    @FXML
    protected void handleReminderButtonAction(ActionEvent event) {
        actiontarget.setText("Reminder button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.close();
        ReminderCntl reminderCtrl = ReminderCntl.getReminderCntl(theStage);
        reminderCtrl.setUpReminderListScene();
    }

    @FXML
    protected void handleActivityButtonAction(ActionEvent event) {
        actiontarget.setText("Activity button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.close();
        ActivityCtrl activityCtrl = ActivityCtrl.getActivityCtrl(theStage);
        activityCtrl.setUpActivityListScene();
    }

    @FXML
    protected void handleExpensesButtonAction(ActionEvent event) {
        actiontarget.setText("Expenses button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.close();
        ExpenseCtrl expenseCtrl = ExpenseCtrl.getExpenseCtrl(theStage);
        expenseCtrl.setUpExpenseListScene();
    }

}
