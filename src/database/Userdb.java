package org.example.database;

import org.example.models.user.User;

import java.util.HashMap;

public class Userdb {
    private static org.example.database.Userdb udb;

    public HashMap<String, User> user;

    private Userdb() {
    }

    public static org.example.database.Userdb udb() {
        if (udb == null) {
            udb = new org.example.database.Userdb();
        }
        return udb;
    }

    public void deleteCreator(String uid){
        User obj = user.get(uid);
        TheatreDB.tdb().deleteCreator(obj);
        user.remove(uid);
    }

    public void deleteCustomer(String uid){
        User obj = user.get(uid);
        BookingDB.bdb().removeBookingsOfUser(uid);
        user.remove(uid);
    }


}
