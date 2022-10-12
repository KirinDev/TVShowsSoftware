package app.domain.store;

import app.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class CompMovieStore {

    private List<Movie> store = new ArrayList<>();

    public CompMovieStore() { }

    public boolean add(Movie movie) {
        return movie != null && !this.exists(movie) ?this.store.add(movie) : false;
    }

    public boolean remove(Movie movie) {
        return movie != null ? this.store.remove(movie) : false;
    }

    public List<Movie> getAll() {
        return this.store;
    }

    public boolean exists( Movie movie ) {

        for (Movie i : this.store) {
            if (i.getName().equals(movie.getName()))
                return true;
        }
        return false;
    }
}
