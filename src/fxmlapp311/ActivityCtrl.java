package fxmlapp311;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActivityCtrl {

    private static ActivityCtrl theActivityCtrl;
    @FXML
    private Stage stage;
    private ObservableList<Activity> theListOfActivities;

    private ActivityCtrl(Stage theExistingStage) {
        stage = theExistingStage;
        setUpActivityListScene();
        stage.show();
    }

    public static ActivityCtrl getActivityCtrl(Stage theStage) {
        if (theActivityCtrl != null) {
            return theActivityCtrl;
        } else {
            theActivityCtrl = new ActivityCtrl(theStage);
            return theActivityCtrl;
        }
    }

    @FXML
    public void setUpActivityListScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("ActivityUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Activities");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addActivityRow(Activity newActivity) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getActivityList().getActivityData().add(newActivity);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public void deleteActivityRow(Activity newActivity) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getActivityList().getActivityData().remove(newActivity);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public ObservableList<Activity> getListOfActivities() {
        return theListOfActivities;
    }
}
