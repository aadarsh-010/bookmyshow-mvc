package org.example.database;

import models.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Showdb {
    private static org.example.database.Showdb swdb;
    public HashMap<String, ArrayList<String>> ShowSeat;
    public HashMap<String, Show> Showdb;

    private Showdb() {
        this.Showdb = new HashMap<>();
        this.ShowSeat = new HashMap<>();
    }

    public static org.example.database.Showdb swdb() {
        if (swdb == null) {
            swdb = new org.example.database.Showdb();
        }
        return swdb;
    }

    public void deleteshow(String showid) {   //deletes show and seats


        for (int k = 0; k < ShowSeat.get(showid).size(); k++) {
            removeSeatfromShow(showid, ShowSeat.get(showid).get(k));
        }
        Showdb.remove(showid);
        ShowSeat.remove(showid);

    }

    public void removeSeatfromShow(String showid, String stid) {  // deeltes specific seat from show

        for (int k = 0; k < ShowSeat.get(showid).size(); k++) {
            String seatid = ShowSeat.get(showid).get(k);

            if (Objects.equals(seatid, stid)) {
                ShowSeat.get(showid).remove(stid);
                SeatDB.Stdb().deleteseat(seatid);

            }

        }

    }
}
