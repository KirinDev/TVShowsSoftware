package app.controller;

import app.domain.model.Anime;
import app.domain.model.Movie;
import app.domain.store.AnimeStore;
import app.mappers.AnimeMapper;
import app.mappers.dto.AnimeDTO;

import java.util.List;
import java.util.Set;

public class DeleteAnimeController {

    private App app;
    private AnimeMapper mapper;
    private AnimeStore store;

    public DeleteAnimeController() {
        this.app = App.getInstance();
        this.mapper = new AnimeMapper();
        this.store = app.getCompany().getAniStore();
    }

    public List<Anime> listAllAnime() {
        this.store = app.getCompany().getAniStore();
        return store.getAll();
    }

    public void delete(Anime anime) {
        this.store.remove(anime);
    }
}
