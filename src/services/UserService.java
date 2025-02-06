package org.example.services;

import org.example.models.user.Creator;
import org.example.models.user.Customer;
import org.example.models.user.User;

import java.util.List;
import java.util.Objects;


public class UserService {

    private static UserService userS;

    private UserService() {
    }

    public static UserService usv() {
        if (userS == null) {
            userS = new UserService();
        }
        return userS;
    }


    public void createUser(String id, String name, String email, String phoneNumber, String userType) {
        if (userType == "CREATOR") {
            User obj1 = new Creator(id, name, email, phoneNumber);
            org.example.database.Userdb.udb().user.put(id, obj1);
        } else {
            User obj1 = new Customer(id, name, email, phoneNumber);
            org.example.database.Userdb.udb().user.put(id, obj1);
        }

    }

    //*************
    public void deleteUser(String id, String email) {
        User obj = org.example.database.Userdb.udb().user.get(id);
        if (Objects.equals(obj.getEmail(), email)) {


            if (obj instanceof Creator) {
                org.example.database.Userdb.udb().deleteCreator(id);
            } else {
                org.example.database.Userdb.udb().deleteCustomer(id);
            }

        } else {
            System.out.println("INVALID REMOVE OF USER , GIVEN WRONG EMAIL");
        }
    }


    // still implementation pending;//downcasting
    public List<String> getOwnedTheatres(String userid) {
        User obj = org.example.database.Userdb.udb().user.get(userid);
        if (obj instanceof Creator) {
            return ((Creator) obj).getOwnedTheatres();
        } else {
            System.out.println("you are customer not creator");
            return null;
        }

    }

    // still implementation pending;
    public List<String> getBookings(String userid) {
        User obj = org.example.database.Userdb.udb().user.get(userid);
        if (obj instanceof Customer) {
            return ((Customer) obj).getBookings();
        } else {
            System.out.println("you are Creator not Customer");
            return null;
        }

    }

}
