package org.example.view;

import org.example.models.Booking;
import org.example.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class BookingDetails {

    public Booking bookingDeatils(String BookingID) {
        Booking b1 = org.example.database.Bookingdb.bdb().Booking.get(BookingID);
        System.out.println(b1);
        return b1;
    }

    public String getShowId(String BookingID) {
        return org.example.database.Bookingdb.bdb().Booking.get(BookingID).getShowId();
    }


    public String getCustomerId(String BookingID) {
        return org.example.database.Bookingdb.bdb().Booking.get(BookingID).getCustomerId();
    }


    public ArrayList<String> getSeatsBooked(String BookingID) {
        return org.example.database.Bookingdb.bdb().Booking.get(BookingID).getSeatsBooked();
    }


    public double getTotalPrice(String BookingID) {
        return org.example.database.Bookingdb.bdb().Booking.get(BookingID).getTotalPrice();
    }


    public String getBookingStatus(String BookingID) {
        return org.example.database.Bookingdb.bdb().Booking.get(BookingID).getBookingStatus();
    }

    public List<String> userBooking(String userID) {
        return UserService.usv().getBookings(userID);
    }



}
