package database;

import models.Screen;
import models.Show;
import models.ShowSeats;
import models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ShowTable {

    public HashMap<String, Show> Showdb;
    public HashMap<String, ShowSeats> showSeatdb;


    public Show getShow(String sid) {
        if(Showdb.containsValue(sid)){
            return Showdb.get(sid);
        }
        System.out.println(" SCREEN NOT PRESENT ");
        return null;
    }

    public void addShow(Show obj) {
        Showdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteShow(String showid) {
            Showdb.remove(showid);
    }



    public ShowSeats getshowSeat(String sid) {
        if(showSeatdb.containsValue(sid)){
            return showSeatdb.get(sid);
        }
        System.out.println(" showseat NOT PRESENT ");
        return null;
    }

    public void addshowSeat(ShowSeats obj) {
        showSeatdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteshowSeat(String showseatid) {
        showSeatdb.remove(showseatid);
    }
}
