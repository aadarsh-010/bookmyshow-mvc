package services;

import database.DatabaseCollection;
import database.MovieTable;
import models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private static MovieService movieServiceObject;
    MovieTable movietable;

    MovieService() {
        movietable = DatabaseCollection.instance().MovieTable;
    }

    public static MovieService instance() {
        if (movieServiceObject == null) movieServiceObject = new MovieService();
        return movieServiceObject;
    }

    public void createMovie(String id, List<String> genre, String title, int duration, String language, ArrayList<String> cast) {
        Movie m1 = new Movie(id, genre, title, duration, language, cast);
        movietable.addMovie(m1);
    }

    public void deleteMovie(String mid) throws Exception {
        movietable.deleteMovie(mid);
    }

    public void addShowRefToMovie(String showid , String movieid){
        movietable.getMovie(movieid).addshowsRunningThisMovie(showid);
    }

    public void removeShowRefToMovie(String showid , String movieid){
        movietable.getMovie(movieid).removeshowsRunningThisMovie(showid);
    }


}
