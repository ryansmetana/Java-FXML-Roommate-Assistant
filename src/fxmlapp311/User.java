package fxmlapp311;

import java.io.*;

public class User implements Serializable {

    private String firstName = new String();
    private String lastName = new String();
    private String username = new String();
    private String password = new String();

    private double waterConsumed = 0;
    private double electricConsumed = 0;

    public User(String newFirstName, String newLastName, String newUsername, String newPassword) {
        firstName = newFirstName;
        lastName = newLastName;
        username = newUsername;
        password = newPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String newUsername) {
        username = newUsername;
    }

    public void setWaterConsumed(double wC) {
        waterConsumed = wC;
    }

    public Double getWaterConsumed() {
        return waterConsumed;
    }

    public void setElectricConsumed(double eC) {
        electricConsumed = eC;
    }

    public Double getElectricConsumed() {
        return electricConsumed;
    }
}
