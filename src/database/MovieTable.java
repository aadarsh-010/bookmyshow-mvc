package database;


import models.Movie;
import models.Screen;
import models.Theatre;

import java.util.HashMap;

public class MovieTable {

    public HashMap<String, Movie> MovieTable;

    public Movie getMovie(String mid) {
        if(MovieTable.containsValue(mid)){
            return MovieTable.get(mid);
        }
        System.out.println(" MOVIE NOT PRESENT ");
        return null;
    }

    public void addMovie(Movie obj) {
        MovieTable.putIfAbsent(obj.getId(),obj);
    }

    public void deleteMovie(String mid) {
        MovieTable.remove(mid);
    }


}
