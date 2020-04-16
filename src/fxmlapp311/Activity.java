package fxmlapp311;

import java.io.Serializable;

public class Activity implements Serializable {

    private String description;

    public Activity(String a) {
        description = a;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }
}
