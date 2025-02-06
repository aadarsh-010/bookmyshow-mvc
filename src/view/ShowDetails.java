package org.example.view;

import org.example.services.ShowService;

public class ShowDetails {

    public int getAvaiableSeats(String showid){
        return ShowService.ssv().getAvaiableSeats(showid);
    }

    public void getMovieId(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getMovieId();
    }

    public void getTheatreId(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getTheatreId();
    }

    public void setScreenId(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getScreenId();
    }


    public void setStartTime(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getStartTime();
    }


    public void setEndTime(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getStartTime();
    }


    public void setSeatPrices(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getSeatPrices();
    }


    public void setSeatTypeCount(String sid ) {
        org.example.database.ShowTable.swdb().Showdb.get(sid).getSeatTypeCount();
    }



}
