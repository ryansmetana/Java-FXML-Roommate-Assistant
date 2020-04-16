package fxmlapp311;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class NavigationCntl {

    @FXML
    private Stage stage;
    @FXML
    private Text actiontarget;
    private static NavigationCntl theNavigationCntl;

    public NavigationCntl(Stage theExistingStage) {
        stage = theExistingStage;
        setUpNavigationScene();
        stage.show();
    }

    public static NavigationCntl getNavigationCntl(Stage theStage) {
        if (theNavigationCntl != null) {
            theStage.show();
            return theNavigationCntl;
        } else {
            theNavigationCntl = new NavigationCntl(theStage);
            return theNavigationCntl;
        }
    }

    @FXML
    public void setUpNavigationScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("NavigationUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Navigation");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUserCntl(Stage theStage) {
        UserCntl.getUserCntl(theStage);
    }

    public void getReminderCntl(Stage theStage) {
        ReminderCntl.getReminderCntl(theStage);
    }
    
    public void getExpenseCtrl(Stage theStage){
        ExpenseCtrl.getExpenseCtrl(theStage);
    }
    
    public void getActivityCtrl(Stage theStage){
        ActivityCtrl.getActivityCtrl(theStage);
    }
    
   

    public void exit() {
        System.exit(0);
    }

}
