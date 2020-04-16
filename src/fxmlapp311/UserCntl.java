package fxmlapp311;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

public class UserCntl {

    @FXML
    private Stage stage;
    private static UserCntl theUserCntl;
    private ObservableList<User> theListOfUsers;

    private UserCntl(Stage theExistingStage) {
        theListOfUsers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData();
        stage = theExistingStage;
        this.setUpUserListScene();
        stage.show();
    }

    public static UserCntl getUserCntl(Stage theStage) {
        if (theUserCntl != null) {
            return theUserCntl;
        } else {
            theUserCntl = new UserCntl(theStage);
            return theUserCntl;
        }
    }

    @FXML
    public void setUpUserListScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("UserUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Users");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserRow(User newUser) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData().add(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public void deleteUserRow(User newUser) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().getUserData().remove(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public ObservableList<User> getListOfUsers() {
        return theListOfUsers;
    }
}
