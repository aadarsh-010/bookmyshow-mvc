package org.example.models;

import enums.BookingStatus;
import enums.SeatBookingStatus;
import enums.SeatType;

public class Seat {

    private String id;
    private int row;
    private int col;
    private SeatBookingStatus seatBookingStatus;
    private SeatType seatType;
    private String showid;
    private Integer price;

    public Seat(String id ,int row , int col, String seatType,String showid,Integer price) {
        this.id = id;
        this.row = row;
        this.col=col;
        this.isBooked = false;
        this.seatType = seatType;
        this.showid=showid;
        this.price=price;
    }

    public void bookSeat(String userid) { this.isBooked = true; this.userid=userid;}

    public void cancelSeat() { this.isBooked = false;  this.userid=null; }




    //------------------------------------------------------------------------------------------------------------------------------------------

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }


}
