package app.domain.store;

import app.domain.model.Movie;

import java.util.*;

public class MovieStore {

    private List<Movie> store = new ArrayList<>();

    public MovieStore() { }

    public Movie create(String name, int aired, String genres, Double duration, Double score) {
        return new Movie(name, aired, genres, duration, score);
    }

    public boolean add(Movie movie) {
        return movie != null && !this.exists(movie) ?this.store.add(movie) : false;
    }

    public boolean remove(Movie movie) {
        return movie != null ? this.store.remove(movie) : false;
    }

    public List<Movie> getAll() {
        return this.store;
    }

    public boolean validate(Movie movie) {
        return checkAired(movie.getAired()) && checkDuration(movie.getDuration()) && checkScore(movie.getScore());
    }

    public boolean save(Movie movie) {
        if( validate(movie) ) {
            add(movie);
            return true;
        }else{
            return false;
        }
    }

    public boolean exists( Movie movie ) {

        for (Movie i : this.store) {
            if (i.getName().equals(movie.getName()))
                return true;
        }
        return false;
    }

    public Movie getByName(String name ) {
        for (Movie i : this.store) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    public boolean checkAired( int aired ) {
        return aired >= 1900 && aired <= 2023;
    }

    public boolean checkDuration( double duration ) {
        return duration > 0;
    }

    public boolean checkScore( double score ) {
        return score >= 0 && score <= 10;
    }
}
