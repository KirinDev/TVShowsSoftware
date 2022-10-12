package app.controller;

import app.domain.model.Movie;
import app.domain.store.CompMovieStore;
import app.domain.store.MovieStore;

public class AddMovieController {

    private App app;
    private CompMovieStore store;
    private MovieStore movStore;

    public AddMovieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getCompMovStore();
        this.movStore = app.getCompany().getMovStore();
    }

    public Movie getByName(String name ) {
        return this.movStore.getByName(name);
    }

    public boolean addMovie( Movie movie ) {
        return this.store.add(movie);
    }
}
