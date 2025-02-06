package org.example.database;

import org.example.models.Seat;

import java.util.HashMap;

public class Seatdb {

    private static org.example.database.Seatdb stdb;
    public HashMap<String, Seat> Seat;


    private Seatdb() {
        this.Seat=new HashMap<>();
    }

    public static org.example.database.Seatdb Stdb() {
        if (stdb == null) {
            stdb = new org.example.database.Seatdb();
        }
        return stdb;
    }

    public void deleteseat(String seatid) {

        if (Seat.get(seatid).isBooked()) {
            BookingDB.bdb().removeBookings(Seat.get(seatid).getBookingID());
        }
        Seat.remove(seatid);
    }


}
