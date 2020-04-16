package fxmlapp311;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReminderCntl {

    private static ReminderCntl theReminderCntl;
    @FXML
    private Stage stage;
    private ObservableList<Reminder> theListOfReminders;

    private ReminderCntl(Stage theExistingStage) {
        theListOfReminders = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData();
        stage = theExistingStage;
        setUpReminderListScene();
        stage.show();
    }

    public static ReminderCntl getReminderCntl(Stage theStage) {
        if (theReminderCntl != null) {
            return theReminderCntl;
        } else {
            theReminderCntl = new ReminderCntl(theStage);
            return theReminderCntl;
        }
    }

    @FXML
    public void setUpReminderListScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("ReminderUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Reminders");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addReminderRow(Reminder newReminder) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData().add(newReminder);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public void deleteReminderRow(Reminder newReminder) {
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getReminderList().getReminderData().remove(newReminder);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }

    public ObservableList<Reminder> getListOfReminders() {
        return theListOfReminders;
    }

    public Stage getStage() {
        return stage;
    }
}
