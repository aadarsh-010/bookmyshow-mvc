package database;


import models.Screen;
import models.Seat;
import models.Theatre;

import java.util.HashMap;

public class SeatTable {

    public HashMap<String,Seat> Seatdb;


    public Seat getSeat(String sid) {
        if(Seatdb.containsValue(sid)){
            return Seatdb.get(sid);
        }
        System.out.println(" Seat NOT PRESENT ");
        return null;
    }

    public void addSeat(Seat obj) {
        Seatdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteSeat(String sid) {
        Seatdb.remove(sid);
    }


}
