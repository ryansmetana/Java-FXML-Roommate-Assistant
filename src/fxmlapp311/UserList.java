package fxmlapp311;

import javafx.collections.*;
import java.io.*;
import java.util.*;

public class UserList implements Serializable {

    //private ObservableList<User> theListOfUsers;
    private ArrayList<User> theListOfUsersAL;

    public UserList() {
        theListOfUsersAL = getTestUsers();
    }

    public ObservableList<User> getUserData() {
        ObservableList<User> theListOfUsers;
        List<User> userList = (List<User>) theListOfUsersAL;
        theListOfUsers = FXCollections.observableList(userList);
        return theListOfUsers;
    }

    public ArrayList<User> getTestUsers() {
        ArrayList<User> testUsers = new ArrayList();
        for (int i = 0; i < 4; i++) {
            User newUser = new User("First" + i, "Last" + i, "username" + i, "password" + i);
            testUsers.add(newUser);
        }
        return testUsers;
    }

}
