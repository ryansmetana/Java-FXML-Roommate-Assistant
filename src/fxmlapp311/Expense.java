package fxmlapp311;

import java.io.Serializable;

public class Expense implements Serializable {

    private String roommate;
    private String description;
    private double fee;

    public Expense(String r, String d, double f) {
        roommate = r;
        description = d;
        fee = f;
    }

    public String getRoommate() {
        return roommate;
    }

    public String getDescription() {
        return description;
    }

    public double getFee() {
        return fee;
    }

    public void setRoommate(String newRoommate) {
        roommate = newRoommate;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setFee(double newFee) {
        fee = newFee;
    }
}
