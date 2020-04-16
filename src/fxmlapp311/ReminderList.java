package fxmlapp311;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReminderList implements Serializable {

    private ObservableList<Reminder> theListOfReminders;
    private ArrayList<Reminder> theListOfRemindersAL;

    public ReminderList() {
        theListOfRemindersAL = getTestReminders();
    }

    public ObservableList<Reminder> getReminderData() {
        ObservableList<Reminder> theListOfReminders;
        List<Reminder> reminderList = (List<Reminder>) theListOfRemindersAL;
        theListOfReminders = FXCollections.observableList(reminderList);
        return theListOfReminders;
    }

    public ArrayList<Reminder> getTestReminders() {
        ArrayList<Reminder> testReminders = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Reminder newReminder = new Reminder("Description" + i, "Roommate" + i);
            testReminders.add(newReminder);
        }
        return testReminders;
    }

}
