package org.example.services;

import org.example.models.Booking;
import org.example.models.Screen;

import java.util.ArrayList;
import java.util.Objects;

public class ScreenService {



    public void CreateScreen(String id, String theatreid, int totalSeats,ArrayList<String> seatType){

        Screen obj1 = new Screen(id,theatreid,totalSeats,seatType);
        org.example.database.Theatredb.tdb().Screen.putIfAbsent(id,obj1);
        org.example.database.Theatredb.tdb().ScreenShow.putIfAbsent(id,new ArrayList<>());
        addScreenToTheatre(theatreid,id);

    }
    public void addScreenToTheatre(String Theatreid, String Screenid) {
            org.example.database.Theatredb.tdb().TheatreScreen.putIfAbsent(Theatreid,new ArrayList<>());
            org.example.database.Theatredb.tdb().TheatreScreen.get(Theatreid).add(Screenid);

    }

    public void DeleteScreen(String sid,String theaterid){
        if(Objects.equals(theaterid, org.example.database.Theatredb.tdb().Screen.get(sid).gettheatreid()))
            org.example.database.Theatredb.tdb().deleteScreen(sid);
    }


    //....................................................................... Screen basic taasks

    public void settheatreid(String sid,String hallName) {
        org.example.database.Theatredb.tdb().Screen.get(sid).settheatreid(hallName);
    }


    public void setTotalSeats(String sid,int totalSeats) {
        org.example.database.Theatredb.tdb().Screen.get(sid).setTotalSeats(totalSeats);
    }


    public void setSeatType( String sid,ArrayList<String> seatType) {
        org.example.database.Theatredb.tdb().Screen.get(sid).setSeatType(seatType);
    }


}
