package services;

import database.DatabaseCollection;
import database.SeatTable;
import database.ShowTable;
import enums.SeatBookingStatus;
import enums.SeatType;
import models.Seat;
import models.Show;
import models.ShowSeats;

import java.util.HashMap;
import java.util.Map;


public class ShowService {

    public static int globalseatid = 1;

    private static ShowService ShowServiceObject;
    ShowTable showTable;
    SeatTable seatTable;

    ShowService() {
        this.showTable = DatabaseCollection.instance().ShowTable;
        this.seatTable = DatabaseCollection.instance().SeatTable;
    }

    public static ShowService instance() {
        if (ShowServiceObject == null) ShowServiceObject = new ShowService();
        return ShowServiceObject;
    }


    public void CreateShow(String id, String movieId, String theatreId, String screenId, String startTime, String endTime, String showSeatRef, HashMap<enums.SeatType, Integer> PricePerSeatType) {


        Show s1 = new Show(id, movieId, theatreId, screenId, startTime, endTime, showSeatRef);
        generateSeats(id,PricePerSeatType , ScreenService.instance().getScreenSeat(screenId).getSeatTypeAndCount());
        ShowSeats s2 = new ShowSeats(showSeatRef, PricePerSeatType, ScreenService.instance().getScreenSeat(screenId));

        showTable.Showdb.putIfAbsent(id, s1);
        showTable.addshowSeat(s2);
        addshowtoScreen(id);
        addshowtoTheatre(id);

    }
    public void generateSeats(String showid,HashMap<enums.SeatType, Integer> PricePerSeatType,HashMap<enums.SeatType,Integer> seatTypeAndCount){
        for(Map.Entry<SeatType, Integer> mapElement : seatTypeAndCount.entrySet()){
            for (int i = 0; i < mapElement.getValue(); i++) {
                Seat obj = new Seat(Integer.toString(globalseatid), SeatBookingStatus.Open,mapElement.getKey(),showid,PricePerSeatType.get(mapElement.getKey()));
                globalseatid++;
                seatTable.addSeat(obj);
                String x =showTable.getShow(showid).getShowSeatRef();
                showTable.getshowSeat(x).addshowSeatsRef(obj.getId()); //adding seatref overthere;
            }
        }
    };


    public void DeleteShow(String showid) {
        //delete seat ref
        Show s1 = showTable.getShow(showid);
        showTable.deleteshowSeat(s1.getShowSeatRef());
        removeshowtoScreen(showid);
        removeshowtoTheatre(showid);
    }

    public void addshowtoTheatre(String showid) {
        TheaterService.instance().addShowInTheater(showTable.getShow(showid).getTheatreId(), showid);
    }

    public void addshowtoScreen(String showid) {
        ScreenService.instance().addShowToScreen(showid, showTable.getShow(showid).getScreenId());
    }

    public void removeshowtoTheatre(String showid) {
        TheaterService.instance().removeShowInTheater(showTable.getShow(showid).getTheatreId(), showid);
    }

    public void removeshowtoScreen(String showid) {
        ScreenService.instance().removeShowToScreen(showid, showTable.getShow(showid).getScreenId());
    }


    //public int getAvaiableSeats(String showid) {}


}
