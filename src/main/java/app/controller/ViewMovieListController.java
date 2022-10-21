package app.controller;

import app.domain.model.Movie;
import app.domain.store.CompMovieStore;
import app.mappers.MovieMapper;
import app.mappers.dto.MovieDTO;

import java.util.List;

public class ViewMovieListController {

    private App app;
    private MovieMapper mapper;

    public ViewMovieListController() {
        this.app = App.getInstance();
        this.mapper = new MovieMapper();
    }

    public List<MovieDTO> getAllMovies() {
        CompMovieStore store = this.app.getCompany().getCompMovStore();
        List<Movie> lst = store.getAll();
        return this.mapper.toDTO(lst);
    }
}
