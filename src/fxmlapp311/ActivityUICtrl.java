package fxmlapp311;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class ActivityUICtrl implements Initializable {

    @FXML
    private TableView<Activity> activityTable = new TableView<Activity>();
    @FXML
    private TableColumn<Activity, String> descriptionColumn = new TableColumn("Description");
    @FXML
    private ObservableList<Activity> listOfActivities;
    @FXML
    private Button getSelectedRowButton;
    @FXML
    private Button addRowButton;
    @FXML
    private Button DeleteTaskButton;
    @FXML
    private Button addTaskButton;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Pane CreatePane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfActivities = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getActivityList().getActivityData();

        // Set up the table columns and link them to the table data fields
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("description"));

        // Add the data to the table
        activityTable.setItems(listOfActivities);
    }

    @FXML
    public void showCreatePane() {
        txtDescription.setText("");
        CreatePane.setVisible(true);

    }

    @FXML
    public void addRow() {
        CreatePane.setVisible(false);
        Activity tempActivity = new Activity(txtDescription.getText());
        Stage theStage = (Stage) activityTable.getScene().getWindow();
        ActivityCtrl.getActivityCtrl(theStage).addActivityRow(tempActivity);
        listOfActivities = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getActivityList().getActivityData();
        activityTable.setItems(listOfActivities);
    }

    @FXML
    public void deleteRow() {
        Activity tempActivity = activityTable.getSelectionModel().getSelectedItem();
        if (tempActivity == null){
            JOptionPane.showMessageDialog(null, "Please Select A Activity To Delete");
        }
        else{
            Stage theStage = (Stage) addTaskButton.getScene().getWindow();
            ActivityCtrl.getActivityCtrl(theStage).deleteActivityRow(tempActivity);
            listOfActivities = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getActivityList().getActivityData();
            activityTable.setItems(listOfActivities);
        }
        
    }

    @FXML
    public void back() {
        Stage theStage = (Stage) addTaskButton.getScene().getWindow();
        theStage.close();
        NavigationCntl navCtrl = NavigationCntl.getNavigationCntl(theStage);
        navCtrl.setUpNavigationScene();
    }

    @FXML
    public void openHelp() {
        JOptionPane.showMessageDialog(null, "Use the activity page to track different tasks\n"
                + "Press 'Add New Task' to create a task and assign it to a roommate\n"
                + "Select a task and press 'Delete Task' to delete the task\n"
                + "Select a task and press 'Edit Task' to edit the task");
    }

}
