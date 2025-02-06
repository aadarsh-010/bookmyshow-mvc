package database;

import models.Theatre;

import java.util.HashMap;

public class TheatreTable {


    public HashMap<String, Theatre> Theatredb;

    public  Theatre getTheatre(String thid) {
        if(Theatredb.containsValue(thid)){
            return Theatredb.get(thid);
        }
        System.out.println(" THEATRE NOT PRESENT ");
        return null;
    }

    public void addTheater(Theatre obj) {
        Theatredb.putIfAbsent(obj.getId(),obj);
    }

    public void deletetheater(String thid) {
        Theatredb.remove(thid);
    }



}
