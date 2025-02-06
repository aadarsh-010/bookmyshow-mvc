package org.example.view;

import java.util.ArrayList;

public class TheatreDetails {


    public ArrayList<String> showsInTheatre(String thid) {

        ArrayList<String> shows = new ArrayList<>();

        for (int i = 0; i < org.example.database.TheatreTable.tdb().TheatreScreen.get(thid).size(); i++) {
            for (int j = 0; j < org.example.database.TheatreTable.tdb().ScreenShow.get(org.example.database.TheatreTable.tdb().TheatreScreen.get(thid).get(i)).size(); j++) {
                String x = org.example.database.TheatreTable.tdb().ScreenShow.get(org.example.database.TheatreTable.tdb().TheatreScreen.get(thid).get(i)).get(j);
                shows.add(x);
            }
        }
        return shows;
    }


    public String getName(String thid) {
        return org.example.database.TheatreTable.tdb().Theatre.get(thid).getName();
    }

    public String getOwnerId(String thid) {
        return org.example.database.TheatreTable.tdb().Theatre.get(thid).getOwnerId();
    }

    public String getLocation(String thid) {
        return org.example.database.TheatreTable.tdb().Theatre.get(thid).getLocation();
    }


}
