package services;

import database.DatabaseCollection;
import database.TheatreTable;
import models.Theatre;
import java.util.ArrayList;

public class TheaterService {

    private static TheaterService theaterServiceObject;
    TheatreTable theatreTable;

    TheaterService() {
        this.theatreTable = DatabaseCollection.instance().TheatreTable;
    }

    public static TheaterService instance() {
        if (theaterServiceObject == null) theaterServiceObject = new TheaterService();
        return theaterServiceObject;
    }



    public void CreateTheater(String id, String name, String location, String ownerId) throws Exception {
                Theatre t1 = new Theatre(id,name,location,ownerId);
                theatreTable.addTheater(t1);
                UserService.instance().addOwnedTheatres(ownerId,id);
    }


    public void DeleteTheater(String id) throws Exception {
        Theatre t1 = theatreTable.getTheatre(id);
        theatreTable.deletetheater(id);
        for(int i = 0; i < t1.getScreen().size(); i++) {
            ScreenService.instance().DeleteScreen(String.valueOf(t1.getScreen().get(i)));
        }
        UserService.instance().removeOwnedTheatres(t1.getOwnerId(),id);
    }

    public void addScreenInTheater(String thid , String screenid) {
        theatreTable.getTheatre(thid).addScreenInTheatre(screenid);
    }

    public void removeScreenInTheater(String thid , String screenid) {
        theatreTable.getTheatre(thid).removeScreenInTheatre(screenid);
    }

    public void addShowInTheater(String thid , String showid) {
        theatreTable.getTheatre(thid).addShowInTheatre(showid);
    }

    public void removeShowInTheater(String thid , String showid) {
        theatreTable.getTheatre(thid).removeShowInTheatre(showid);
    }


}
