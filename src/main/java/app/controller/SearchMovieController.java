package app.controller;

import app.domain.model.Movie;
import app.domain.store.MovieStore;

public class SearchMovieController {

    private App app;

    public SearchMovieController() {
        this.app = App.getInstance();
    }

    public Movie searchMovie(String name) {
        MovieStore store = this.app.getCompany().getMovStore();
        return store.getByName(name);
    }
}
