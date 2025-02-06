package services;

import database.DatabaseCollection;
import database.ScreenTable;
import enums.SeatType;
import models.Screen;
import models.ScreenSeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ScreenService {


    private static ScreenService screenServiceObject;
    ScreenTable screenTable;

    ScreenService() {
        this.screenTable = DatabaseCollection.instance().ScreenTable;
    }

    public static ScreenService instance() {
        if (screenServiceObject == null) screenServiceObject = new ScreenService();
        return screenServiceObject;
    }


    public void CreateScreenSeats(String id ,int totalSeats, HashMap<SeatType, Integer> seatTypeAndCount){

        ScreenSeat sc1 = new ScreenSeat(id,totalSeats,seatTypeAndCount);
        screenTable.ScreenSeatTable.putIfAbsent(id,sc1);

    }
    public void CreateScreen(String id, String theatreid,String screenSeatID ,int totalSeats, HashMap<SeatType,Integer> seatTypeAndCount ){

        Screen obj1 = new Screen(id,theatreid,screenSeatID);
        screenTable.ScreenTable.putIfAbsent(id,obj1);
        CreateScreenSeats(screenSeatID,totalSeats,seatTypeAndCount);
        addScreenToTheatre(theatreid,id);

    }

    public ScreenSeat getScreenSeat(String screenid){
        String x=screenTable.getScreen(screenid).getScreenSeatID();
        return screenTable.getScreenSeat(x);
    }

    public void addScreenToTheatre(String Theatreid, String Screenid) {
        TheaterService.instance().addScreenInTheater(Theatreid,Screenid);

    }

    public void removeScreenToTheatre(String Theatreid, String Screenid) {
        TheaterService.instance().removeScreenInTheater(Theatreid,Screenid);
    }

    public void addShowToScreen(String shwid, String Screenid) {
        screenTable.getScreen(Screenid).addShowInScreen(shwid);

    }

    public void removeShowToScreen(String shwid, String Screenid) {
        screenTable.getScreen(Screenid).removeShowInScreen(shwid);
    }

    public void DeleteScreen(String sid){
            screenTable.deleteScreen(sid);
            removeScreenToTheatre(screenTable.getScreen(sid).getTheatreid(),sid);
            screenTable.deleteScreenSeat(screenTable.getScreen(sid).getScreenSeatID()); // delete krra hu screenseat bhi
    }





}
