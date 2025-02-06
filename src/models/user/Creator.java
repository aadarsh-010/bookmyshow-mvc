package models.user;

import java.util.ArrayList;

public class Creator extends User {
    private ArrayList<String> theatresOwned;


    public Creator(String id, String name, String email, String phoneNumber) {
        super(id, name, email, phoneNumber);

    }
}
