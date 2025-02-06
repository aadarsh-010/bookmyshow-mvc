package database;

import models.user.Creator;
import models.user.Customer;

import java.util.HashMap;
import java.util.Objects;

public class UserTable {

    public HashMap<String, Creator> creatorDB;
    public HashMap<String, Customer> customerDB;


    public Creator getCreator(String uid) {
        if (Objects.equals(userIsA(uid), "CREATOR") && creatorDB.containsValue(uid)) {
            return creatorDB.get(uid);
        } else System.out.println("INVALID USER ID USER NOT PRESENT");

        return null;
    }

    public Customer getCustomer(String uid) {
        if (Objects.equals(userIsA(uid), "CUSTOMER") && creatorDB.containsValue(uid)) {
            return customerDB.get(uid);
        } else System.out.println("INVALID USER ID USER NOT PRESENT");

        return null;
    }

    public void deleteCreator(String uid) {
    }

    public void deleteCustomer(String uid) {
    }


    public void addCustomer(String id, Customer obj1) {
    }

    public void addCreator(String id, Creator obj1) {
    }

    public String userIsA(String id) {
        if (customerDB.containsValue(id)) {
            return "CUSTOMER";
        } else if (creatorDB.containsValue(id)) {
            return "CREATOR";
        }
        return "INVALID USER";
    }
}
