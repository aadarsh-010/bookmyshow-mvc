package models;


import enums.SeatType;

import java.util.ArrayList;
import java.util.HashMap;

public class ScreenSeat {
    String id;
    int totalSeats;
    HashMap<enums.SeatType,Integer> seatTypeAndCount;

    public ScreenSeat(String id ,int totalSeats, HashMap<SeatType, Integer> seatTypeAndCount) {
        this.totalSeats = totalSeats;
        this.seatTypeAndCount = seatTypeAndCount;
        this.id=id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public HashMap<SeatType, Integer> getSeatTypeAndCount() {
        return seatTypeAndCount;
    }

    public void setSeatTypeAndCount(HashMap<SeatType, Integer> seatTypeAndCount) {
        this.seatTypeAndCount = seatTypeAndCount;
    }
}
