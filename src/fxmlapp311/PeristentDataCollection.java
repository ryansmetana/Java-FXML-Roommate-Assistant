package fxmlapp311;

import java.io.*;

public class PeristentDataCollection implements Serializable {

    private UserList theUserList;

    // All other persistent data will go below here
    private ReminderList theReminderList;
    private ActivityList theActivityList;
    private ExpenseList theExpenseList;

    public PeristentDataCollection() {
        if (theUserList == null) {
            theUserList = new UserList();
        }

        if (theReminderList == null) {
            theReminderList = new ReminderList();
        }

        if (theActivityList == null) {
            theActivityList = new ActivityList();
        }

        if (theExpenseList == null) {
            theExpenseList = new ExpenseList();
        }
    }

    public UserList getuserList() {
        return theUserList;
    }

    public ReminderList getReminderList() {
        return theReminderList;
    }

    public ActivityList getActivityList() {
        return theActivityList;
    }

    public ExpenseList getExpenseList() {
        return theExpenseList;
    }

}
