package models;

import enums.BookingStatus;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String id;
    private String customerId;
    private String showId;
    private ArrayList<String> BookedSeatsRef; //seatid list
    private double totalPrice;
    private BookingStatus bookingStatus;

    public Booking(String id, String customerId, String showId, ArrayList<String> seatsBooked, double totalPrice, BookingStatus bookingStatus) {
        this.id = id;
        this.customerId = customerId;
        this.showId = showId;
        this.BookedSeatsRef = seatsBooked;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }



}
