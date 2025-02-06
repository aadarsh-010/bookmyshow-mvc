package database;

import models.Booking;
import models.Movie;

import java.util.HashMap;

public class BookingTable {
    public HashMap<String, Booking> BookingTable;

    public Booking getBooking(String bid) {
        if(BookingTable.containsValue(bid)){
            return BookingTable.get(bid);
        }
        System.out.println(" BOOKING NOT PRESENT ");
        return null;
    }

    public void addBooking(Booking obj) {
        BookingTable.putIfAbsent(obj.getId(),obj);
    }

    public void deleteBooking(String bid) {
        BookingTable.remove(bid);
    }
}
