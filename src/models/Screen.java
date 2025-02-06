package org.example.models;


import models.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Screen {

    private String id;
    private String theatreid;
    private int totalSeats;
    private String screenSeatID;

    private ArrayList<String> screensRef;


    public Screen(String id, String theatreid, int totalSeats, String seatType) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.theatreid = theatreid;
        this.screenSeatID = seatType;
    }


    public List<Show> getScreens() {
        return null;
    }


}

