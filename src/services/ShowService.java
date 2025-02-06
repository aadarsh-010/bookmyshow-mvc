package org.example.services;

import org.example.models.Seat;
import org.example.models.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ShowService {

    private static ShowService showS;

    private ShowService() {
    }

    public static ShowService ssv() {
        if (showS == null) {
            showS = new ShowService();
        }
        return showS;
    }




    public void CreateShow(String id, String movieId, String theatreId, String screenId, String startTime, String endTime, ArrayList<String> seatType,ArrayList<Integer> seatPrices,ArrayList<ArrayList<Integer>> eachSeatTypeCount){
        Show obj1 = new Show(id,movieId,theatreId,screenId,startTime,endTime,seatType,seatPrices,eachSeatTypeCount);

        org.example.database.Showdb.swdb().Showdb.put(id,obj1);
        org.example.database.Theatredb.tdb().ScreenShow.putIfAbsent(screenId,new ArrayList<>());
        org.example.database.Theatredb.tdb().ScreenShow.get(screenId).add(id);

        CreateSeats(id,seatType,seatPrices,eachSeatTypeCount);

    }

    public void CreateSeats(String showid, ArrayList<String> seatType,ArrayList<Integer> seatPrices,ArrayList<ArrayList<Integer>> eachSeatTypeCount){
        for (int i=0;i<seatType.size();i++){
            for (int j = 0; j < eachSeatTypeCount.get(i).size(); j++) {
                for (int k = 0; k < eachSeatTypeCount.get(i).get(j); k++) {
                    String seatid = Integer.toString(i)+"_"+Integer.toString(j)+"_"+Integer.toString(k);
                    Seat obj1 = new Seat(seatid,j,k,seatType.get(i),showid,seatPrices.get(i));
                    org.example.database.Seatdb.Stdb().Seat.put(seatid,obj1);
                    org.example.database.Showdb.swdb().ShowSeat.putIfAbsent(showid,new ArrayList<>());
                    org.example.database.Showdb.swdb().ShowSeat.get(showid).add(seatid);

                }
            }
        }
    }

    public void DeleteShow(String Screenid , String showid){
        if(Objects.equals(Screenid, org.example.database.Showdb.swdb().Showdb.get(showid).getScreenId()))
            org.example.database.Showdb.swdb().deleteshow(showid);
    }



    public int getAvaiableSeats(String showid){
        int count =0;
        for (int i = 0; i < org.example.database.Showdb.swdb().ShowSeat.get(showid).size(); i++) {
            String s= org.example.database.Showdb.swdb().ShowSeat.get(showid).get(i);
            System.out.println("Available Seats : - ");
                if(!org.example.database.Seatdb.Stdb().Seat.get(s).isBooked()){
                    count++;
                    System.out.println(org.example.database.Seatdb.Stdb().Seat.get(s).getId());
                }
        }
        return count;
    }

//------------------------------------------



    public void setMovieId(String sid , String movieId) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setMovieId(movieId);
    }

    public void setTheatreId(String sid ,String theatreId) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setTheatreId(theatreId);
    }

    public void setScreenId(String sid ,String screenId) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setScreenId(screenId);
    }


    public void setStartTime(String sid ,String startTime) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setStartTime(startTime);
    }


    public void setEndTime(String sid ,String endTime) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setEndTime(endTime);
    }


    public void setSeatPrices(String sid ,HashMap<String, Integer> seatPrices) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setSeatPrices(seatPrices);
    }


    public void setSeatTypeCount(String sid ,HashMap<String, ArrayList<Integer>> seatTypeCount) {
        org.example.database.Showdb.swdb().Showdb.get(sid).setSeatTypeCount(seatTypeCount);
    }
}
