package app.controller;

import app.domain.model.Movie;
import app.domain.store.MovieStore;

public class RegisterMovieController {

    private App app;
    private Movie movie;
    private MovieStore store;

    public RegisterMovieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getMovStore();
    }

    public boolean create(String name, int aired, String genres, double duration, double score) {
        this.movie = this.store.create(name, aired, genres, duration, score);
        return store.validate(movie);
    }

    public boolean save() {
        return store.save(movie);
    }
}
