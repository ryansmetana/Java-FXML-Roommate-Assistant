package fxmlapp311;

import java.io.Serializable;

public class Reminder implements Serializable {

    private String description;
    private String roommate;

    public Reminder(String d, String r) {
        description = d;
        roommate = r;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public String getRoommate() {
        return roommate;
    }

    public void setRoommate(String newRoommate) {
        roommate = newRoommate;
    }

}
