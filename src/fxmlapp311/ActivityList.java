package fxmlapp311;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ActivityList implements Serializable {

    private ObservableList<Activity> theListOfActivities;
    private ArrayList<Activity> theListOfActivitiesAL;

    public ActivityList() {
        theListOfActivitiesAL = getTestActivities();
    }

    public ObservableList<Activity> getActivityData() {
        ObservableList<Activity> theListOfActivities;
        List<Activity> activityList = (List<Activity>) theListOfActivitiesAL;
        theListOfActivities = FXCollections.observableList(activityList);
        return theListOfActivities;
    }

    public ArrayList<Activity> getTestActivities() {
        ArrayList<Activity> testActivities = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Activity newActivity = new Activity("Description" + i);
            testActivities.add(newActivity);
        }
        return testActivities;
    }

}
