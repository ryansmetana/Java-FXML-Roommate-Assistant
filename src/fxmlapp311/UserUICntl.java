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
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class UserUICntl implements Initializable {

    @FXML
    private TableView<User> userTable = new TableView<User>();
    @FXML
    private TableColumn<User, String> firstNameColumn = new TableColumn("First Name");
    @FXML
    private TableColumn<User, String> lastNameColumn = new TableColumn("Last Name");
    @FXML
    private TableColumn<User, String> usernameColumn = new TableColumn("Username");
    @FXML
    private TableColumn<User, String> waterColumn = new TableColumn("Water Consumed");
    @FXML
    private TableColumn<User, String> electricColumn = new TableColumn("Electric Consumed");
    @FXML
    private ObservableList<User> listOfUsers;
    @FXML
    private Button deleteUserButton;
    @FXML
    private Button addUserButton;

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtUsernameUtil;
    @FXML
    private TextField txtWaterConsumed;
    @FXML
    private TextField txtElectricConsumed;
    @FXML
    private Pane CreatePane;
    @FXML
    private Pane updatePane;

    private String selectedUsername = "";
    private String selectedFirstName = "";
    private String selectedLastName = "";
    private double selectedWaterConsumed = 0;
    private double selectedElectricConsumed = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get the data for the table
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();

        // Set up the table columns and link them to the table data fields
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        waterColumn.setCellValueFactory(new PropertyValueFactory<User, String>("waterConsumed"));
        electricColumn.setCellValueFactory(new PropertyValueFactory<User, String>("electricConsumed"));

        // Add the data to the table
        userTable.setItems(listOfUsers);
    }

    public void editUserRow() {
        User tempUser = userTable.getSelectionModel().getSelectedItem();
        selectedFirstName = tempUser.getFirstName();
        selectedLastName = tempUser.getLastName();
        selectedUsername = tempUser.getUsername();
        selectedWaterConsumed = tempUser.getWaterConsumed();
        selectedElectricConsumed = tempUser.getElectricConsumed();

        txtFirstName.setText(selectedFirstName);
        txtLastName.setText(selectedLastName);
        txtUsername.setText(selectedUsername);

        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).deleteUserRow(tempUser);
    }

    @FXML
    public void editRow(ActionEvent e) {
        editUserRow();
        CreatePane.setVisible(true);
    }

    @FXML
    public void updateUtilitiesButton(ActionEvent e) {
        updateUtilities();
        updatePane.setVisible(true);
    }

    @FXML
    public void updateUtilities() {
        User tempUser = userTable.getSelectionModel().getSelectedItem();
        selectedFirstName = tempUser.getFirstName();
        selectedLastName = tempUser.getLastName();
        selectedUsername = tempUser.getUsername();
        selectedWaterConsumed = tempUser.getWaterConsumed();
        selectedElectricConsumed = tempUser.getElectricConsumed();

        txtUsernameUtil.setText(selectedUsername);
        txtWaterConsumed.setText(String.valueOf(selectedWaterConsumed));
        txtElectricConsumed.setText(String.valueOf(selectedElectricConsumed));

        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).deleteUserRow(tempUser);
    }

    public void changeUtilities() {
        updatePane.setVisible(false);
        User tempUser = new User(selectedFirstName, selectedLastName, selectedUsername, "AddPassword");
        tempUser.setElectricConsumed(Double.valueOf(txtElectricConsumed.getText()));
        tempUser.setWaterConsumed(Double.valueOf(txtWaterConsumed.getText()));

        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).addUserRow(tempUser);
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        userTable.setItems(listOfUsers);
    }

    @FXML
    public void showCreatePane() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtUsername.setText("");
        CreatePane.setVisible(true);
    }

    @FXML
    public void addUser() {
        CreatePane.setVisible(false);
        User tempUser = new User(txtFirstName.getText(), txtLastName.getText(), txtUsername.getText(), "AddPassword");
        tempUser.setElectricConsumed(selectedElectricConsumed);
        tempUser.setWaterConsumed(selectedWaterConsumed);
        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).addUserRow(tempUser);
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        userTable.setItems(listOfUsers);
        selectedFirstName = "";
        selectedLastName = "";
        selectedUsername = "";
        selectedWaterConsumed = 0;
        selectedElectricConsumed = 0;
    }

    @FXML
    public void deleteUser() {
        User tempUser = userTable.getSelectionModel().getSelectedItem();
        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        UserCntl.getUserCntl(theStage).deleteUserRow(tempUser);
        listOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        userTable.setItems(listOfUsers);
    }

    @FXML
    public void back() {
        Stage theStage = (Stage) addUserButton.getScene().getWindow();
        theStage.close();
        NavigationCntl navCtrl = NavigationCntl.getNavigationCntl(theStage);
        navCtrl.setUpNavigationScene();

    }

    @FXML
    public void openHelp() {
        JOptionPane.showMessageDialog(null, "Use the user page to manage the roommates you are connected with\n"
                + "Press 'Add New User' to create a new roommate\n"
                + "Select a roommate and press 'Delete User' to delete the user\n"
                + "Select a roommate and press 'Edit User' to edit the user\n"
                + "Select a roommate and press update ");
    }

}
