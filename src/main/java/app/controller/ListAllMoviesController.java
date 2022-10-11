package app.controller;

import app.domain.model.Movie;
import app.domain.store.MovieStore;
import app.mappers.MovieMapper;
import app.mappers.dto.MovieDTO;

import java.util.List;
import java.util.Set;

public class ListAllMoviesController {

    private App app;
    private MovieMapper mapper;

    public ListAllMoviesController() {
        this.app = App.getInstance();
        this.mapper = new MovieMapper();
    }

    public List<MovieDTO> listAllMovies() {
        MovieStore store = app.getCompany().getMovStore();
        List<Movie> lst = store.getAll();
        return mapper.toDTO(lst);
    }
}
