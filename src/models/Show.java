package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Show {
    private String id;
    private String movieId;
    private String theatreId;
    private String screenId;
    private String startTime;
    private String endTime;
    private String showSeatRef;


    public Show(String id, String movieId, String theatreId, String screenId, String startTime, String endTime, ArrayList<String> seatType,ArrayList<Integer> seatPrices,ArrayList<ArrayList<Integer>> eachSeatTypeCount) {
        this.id = id;
        this.movieId = movieId;
        org.example.database.Moviedb.mdb().MovieShow.putIfAbsent(movieId, new ArrayList<>());
        org.example.database.Moviedb.mdb().MovieShow.get(movieId).add(id);


        this.theatreId = theatreId;
        this.screenId = screenId;
        this.startTime = startTime;
        this.endTime = endTime;


        if (seatType.size() == seatPrices.size() && seatPrices.size() == eachSeatTypeCount.size()) {

            for (int i = 0; i < seatType.size(); i++) {
                this.seatPrices.put(seatType.get(i), seatPrices.get(i));
            }
            for (int i = 0; i < seatType.size(); i++) {
                this.seatTypeCount.put(seatType.get(i), eachSeatTypeCount.get(i));
            }


        } else {
            System.out.println("seatType , seatPrice and number of col in each row of each seatType should be equal");
        }




    }

    //------------------------------------------------------------------------------------------------------------------------------------------


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public HashMap<String, Integer> getSeatPrices() {
        return seatPrices;
    }

    public void setSeatPrices(HashMap<String, Integer> seatPrices) {
        this.seatPrices = seatPrices;
    }

    public HashMap<String, ArrayList<Integer>> getSeatTypeCount() {
        return seatTypeCount;
    }

    public void setSeatTypeCount(HashMap<String, ArrayList<Integer>> seatTypeCount) {
        this.seatTypeCount = seatTypeCount;
    }
}
