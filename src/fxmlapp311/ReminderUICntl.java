package fxmlapp311;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class ReminderUICntl implements Initializable {

    @FXML
    private TableView<Reminder> reminderTable = new TableView<Reminder>();
    @FXML
    private TableColumn<Reminder, String> descriptionColumn = new TableColumn("Description");
    @FXML
    private TableColumn<Reminder, String> roommateColumn = new TableColumn("Roommate");
    @FXML
    private ObservableList<Reminder> listOfReminders;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtRoommate;
    @FXML
    private Button addReminderButton;
    @FXML
    private Button editReminderButton;
    @FXML
    private Button deleteReminderButton;
    @FXML
    private Pane CreatePane;

    private String selectedRoommate;
    private String selectedDescription;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfReminders = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData();

        // Set up the table columns and link them to the table data fields
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Reminder, String>("description"));
        roommateColumn.setCellValueFactory(new PropertyValueFactory<Reminder, String>("roommate"));

        // Add the data to the table
        reminderTable.setItems(listOfReminders);
    }

    @FXML
    public void showCreatePane() {
        CreatePane.setVisible(true);
    }

    public void editReminderRow() {
        Reminder tempR = reminderTable.getSelectionModel().getSelectedItem();
        
        if(tempR == null){
            JOptionPane.showMessageDialog(null, "Please Select A Reminder to Edit");
        }
        else{
            String roommate = tempR.getRoommate();
            String description = tempR.getDescription();

            txtRoommate.setText(roommate);
            txtDescription.setText(description);

            Stage theStage = (Stage) addReminderButton.getScene().getWindow();
            ReminderCntl.getReminderCntl(theStage).deleteReminderRow(tempR);
        }
        
    }

    @FXML
    public void editRow(ActionEvent e) {
        editReminderRow();
        CreatePane.setVisible(true);
    }

    @FXML
    public void addRow(ActionEvent e) {
        Reminder tempReminder = new Reminder(txtDescription.getText(), txtRoommate.getText());
        CreatePane.setVisible(false);
        Stage theStage = (Stage) addReminderButton.getScene().getWindow();
        ReminderCntl.getReminderCntl(theStage).addReminderRow(tempReminder);
        listOfReminders = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData();
        reminderTable.setItems(listOfReminders);
    }

    @FXML
    public void deleteRow(ActionEvent e) {
        Reminder tempReminder = reminderTable.getSelectionModel().getSelectedItem();
        if (tempReminder == null){
            JOptionPane.showMessageDialog(null, "Please Select A Reminder To Delete");
        }
        else{
            Stage theStage = (Stage) addReminderButton.getScene().getWindow();
            ReminderCntl.getReminderCntl(theStage).deleteReminderRow(tempReminder);
            listOfReminders = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData();
            reminderTable.setItems(listOfReminders);
        }
        
    }

    @FXML
    public void back() {
        Stage theStage = (Stage) addReminderButton.getScene().getWindow();
        theStage.close();
        NavigationCntl navCtrl = NavigationCntl.getNavigationCntl(theStage);
        navCtrl.setUpNavigationScene();
    }

    @FXML
    public void openHelp() {
        JOptionPane.showMessageDialog(null, "Use the reminder page to track different reminders\n"
                + "Press 'Add New Reminder' to create a reminder and assign it to a roommate\n"
                + "Select a reminder and press 'Delete Reminder' to delete the reminder\n"
                + "Select a reminder and press 'Edit Reminder' to edit the reminder");
    }

}
