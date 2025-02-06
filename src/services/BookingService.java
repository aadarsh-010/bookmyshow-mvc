package services;

import java.util.ArrayList;
import java.util.HashMap;

public class BookingService {


    public static int BookingID = 0;
    private static BookingService bookS;

    private BookingService() {
    }

    public static BookingService bsv() {
        if (bookS == null) {
            bookS = new BookingService();
        }
        return bookS;
    }

    public synchronized void bookShow(String showid, String userid, int totalTickets, ArrayList<String> seatsBooking) {
        int availableTickets = ShowService.ssv().getAvaiableSeats(showid);
        int totalprice = 0;


        if (availableTickets >= totalTickets) {

            HashMap<String, Integer> h1 = org.example.database.ShowTable.swdb().Showdb.get(showid).getSeatPrices();

            for (String s : seatsBooking) {
                totalprice += org.example.database.SeatTable.Stdb().Seat.get(s).getPrice();
                org.example.database.SeatTable.Stdb().Seat.get(s).bookSeat(userid);
            }


            //PaymentService----------------------------------------
            Booking b1 = new Booking(Integer.toString(BookingID), userid, showid, seatsBooking, totalprice, "Confirmed");
            BookingID++;

            org.example.database.Bookingdb.bdb().Booking.put(Integer.toString(BookingID), b1);
            org.example.database.Bookingdb.bdb().UserBoooking.putIfAbsent(userid, new ArrayList<>());
            org.example.database.Bookingdb.bdb().UserBoooking.get(userid).add(Integer.toString(BookingID));


            System.out.println("Booked " + totalTickets + " tickets, Remaining tickets: " + availableTickets);
        } else {
            System.out.println("Not enough tickets available to book " + totalTickets);
        }
    }

    public void cancelShow(String bid) {
        org.example.database.Bookingdb.bdb().removeBookings(bid);
    }

    public void cancelUserAllShow(String userid) {
        org.example.database.Bookingdb.bdb().removeBookingsOfUser(userid);
    }


}

