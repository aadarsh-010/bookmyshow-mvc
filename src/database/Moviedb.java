package org.example.database;

import org.example.models.Movie;

import java.util.ArrayList;
import java.util.HashMap;

public class Moviedb {

    public HashMap<String, Movie> MovieTable;


    private Moviedb() {
        MovieShow = new HashMap<>();
        Movie = new HashMap<>();
    }

    public static org.example.database.Moviedb mdb() {
        if (mdb == null) {
            mdb = new org.example.database.Moviedb();
        }
        return mdb;
    }


    public void DeleteMovie(String id) {
        for (int i = 0; i < MovieShow.get(id).size(); i++) {
            ShowDB.swdb().deleteshow(MovieShow.get(id).get(i));
        }
        MovieShow.remove(id);
        Movie.remove(id);

    }
}
