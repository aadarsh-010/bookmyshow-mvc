package database;

import models.Screen;
import models.ScreenSeat;
import models.Theatre;

import java.util.HashMap;

public class ScreenTable {
    public HashMap<String, Screen> ScreenTable;
    public HashMap<String, ScreenSeat> ScreenSeatTable;

    public Screen getScreen(String sid) {
        if(ScreenTable.containsValue(sid)){
            return ScreenTable.get(sid);
        }
        System.out.println(" SCREEN NOT PRESENT ");
        return null;
    }

    public void addScreen(Theatre obj) {
        Theatredb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteScreen(String thid) {
        Theatredb.remove(thid);
    }

    public  ScreenSeat getScreenSeat(String ssid) {
        if(ScreenSeatTable.containsValue(ssid)){
            return ScreenSeatTable.get(ssid);
        }
        System.out.println(" SCREEN-SEAT NOT PRESENT ");
        return null;
    }

    public void deleteScreenSeat(String thid) {
        Theatredb.remove(thid);
    }
}
