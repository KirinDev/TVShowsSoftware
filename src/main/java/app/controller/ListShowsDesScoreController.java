package app.controller;

import app.domain.model.Anime;
import app.domain.model.Movie;
import app.domain.model.Serie;
import app.domain.store.AnimeStore;
import app.domain.store.MovieStore;
import app.domain.store.SeriesStore;
import app.mappers.AnimeMapper;
import app.mappers.MovieMapper;
import app.mappers.SerieMapper;
import app.mappers.dto.AnimeDTO;
import app.mappers.dto.MovieDTO;
import app.mappers.dto.SerieDTO;

import java.util.List;

public class ListShowsDesScoreController {

    private App app;
    private AnimeMapper ani_mapper;
    private MovieMapper mov_mapper;
    private SerieMapper ser_mapper;

    public ListShowsDesScoreController() {
        this.app = App.getInstance();
        this.ani_mapper = new AnimeMapper();
        this.mov_mapper = new MovieMapper();
        this.ser_mapper = new SerieMapper();
    }

    public List<AnimeDTO> getOrderedListByScoreDesAnime() {
        AnimeStore store = this.app.getCompany().getAniStore();
        List<Anime> lst = store.orderDesByScore();
        return this.ani_mapper.toDTO(lst);
    }

    public List<MovieDTO> getOrderedListByScoreDesMovie() {
        MovieStore store = this.app.getCompany().getMovStore();
        List<Movie> lst = store.orderDesByScore();
        return this.mov_mapper.toDTO(lst);
    }

    public List<SerieDTO> getOrderedListByScoreDesSeries() {
        SeriesStore store = this.app.getCompany().getSerStore();
        List<Serie> lst = store.orderDesByScore();
        return this.ser_mapper.toDTO(lst);
    }
}
