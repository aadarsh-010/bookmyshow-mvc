package org.example.database;

import org.example.models.Screen;
import org.example.models.Theatre;
import org.example.models.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Theatredb {

    private static org.example.database.Theatredb tdb;
    public HashMap<String, Theatre> Theatre;
    public HashMap<String, ArrayList<String>> ScreenShow;

    private Theatredb() {
        this.Theatre = new HashMap<>();
        this.CreaterTheatre = new HashMap<>();
        this.Screen = new HashMap<>();
        this.TheatreScreen = new HashMap<>();
        this.ScreenShow = new HashMap<>();
    }

    public static org.example.database.Theatredb tdb() {
        if (tdb == null) {
            tdb = new org.example.database.Theatredb();
        }
        return tdb;
    }


    public void deleteCreator(User obj) {
        for (int i = 0; i < CreaterTheatre.get(obj.getId()).size(); i++) {
            deletetheatre(CreaterTheatre.get(obj.getId()).get(i));
        }
        CreaterTheatre.remove(obj.getId());
    }

    public void deletetheatre(String thid) {
        User obj = UserDB.udb().user.get(Theatre.get(thid).getOwnerId());

        for (int i = 0; i < CreaterTheatre.get(obj.getId()).size(); i++) {

            String Theatreid = CreaterTheatre.get(obj.getId()).get(i);
            if (Theatreid == thid) {
                for (int j = 0; j < TheatreScreen.get(Theatreid).size(); j++) {

                    String screenid = TheatreScreen.get(Theatreid).get(j);
                    for (int k = 0; k < ScreenShow.get(screenid).size(); k++) {
                        String shwid = ScreenShow.get(screenid).get(k);
                        ShowDB.swdb().deleteshow(shwid);   // ye seat sb delete kr dera hai

                    }
                    Screen.remove(screenid);
                    ScreenShow.remove(screenid);


                }
                Theatre.remove(Theatreid);
            }


        }


    }


    public void deleteScreen(String screenid) {
        for (int k = 0; k < ScreenShow.get(screenid).size(); k++) {
            String shwid = ScreenShow.get(screenid).get(k);
            ShowDB.swdb().deleteshow(shwid);
        }

        String thid = Screen.get(screenid).gettheatreid();

        for (int i = 0; i < TheatreScreen.get(thid).size(); i++) {
            if (TheatreScreen.get(thid).get(i) == screenid) {
                TheatreScreen.get(thid).remove(i);               // specifically remove kia hu ek screen ko bs
            }
        }


        Screen.remove(screenid);
        ScreenShow.remove(screenid);

    }


}
