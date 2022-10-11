package app.controller;

import app.domain.model.Movie;
import app.domain.store.MovieStore;

import java.util.List;

public class DeleteMovieController {

    private App app;
    private MovieStore store;

    public DeleteMovieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getMovStore();
    }

    public List<Movie> listAllMovie() {
        this.store = app.getCompany().getMovStore();
        return store.getAll();
    }

    public void delete(Movie movie) {
        this.store.remove(movie);
    }
}
