package app.domain.store;

import app.domain.model.Anime;
import app.domain.model.Movie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MovieStore {

    private Set<Movie> store = new HashSet<>();

    public Movie create(String name, int aired, String genres, Double duration, Double score) {
        return new Movie(name, aired, genres, duration, score);
    }

    public boolean add(Movie movie) {
        return movie != null && !this.exists(movie) ?this.store.add(movie) : false;
    }

    public boolean remove(Movie movie) {
        return movie != null ? this.store.remove(movie) : false;
    }

    public Set<Movie> getAll() {
        return Collections.unmodifiableSet(this.store);
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
                return false;
        }
        return true;
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
