package org.example.services;

import org.example.models.Theatre;

import java.util.ArrayList;

public class TheaterService {

    public void CreateTheater(String id, String name, String location, String ownerId){
                Theatre obj1 = new Theatre( id,  name,  location,  ownerId);
                org.example.database.Theatredb.tdb().Theatre.put(id,obj1);
                org.example.database.Theatredb.tdb().CreaterTheatre.putIfAbsent(ownerId,new ArrayList<>());
                org.example.database.Theatredb.tdb().CreaterTheatre.get(ownerId).add(id);
                org.example.database.Theatredb.tdb().CreaterTheatre.putIfAbsent(id,new ArrayList<>());
    }


    public void DeleteTheater(String id){
        org.example.database.Theatredb.tdb().deletetheatre(id);
    }






    //....................................................................... THeatre basic taasks



    public void setTheatreName(String thid,String name) {
        org.example.database.Theatredb.tdb().Theatre.get(thid).setName(name);
    }


    public void setTheatreOwnerId(String thid,String ownerId) {
        org.example.database.Theatredb.tdb().Theatre.get(thid).setOwnerId(ownerId);
    }

    public void setTheatreLocation(String thid,String location) {
        org.example.database.Theatredb.tdb().Theatre.get(thid).setLocation(location);
    }




}
