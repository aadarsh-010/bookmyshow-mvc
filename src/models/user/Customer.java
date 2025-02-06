package models.user;

import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<String> userBookings;


    public Customer(String id, String name, String email, String phoneNumber) {
        super(id,name,email,phoneNumber);
    }
}
