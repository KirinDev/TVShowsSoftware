package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;
import app.mappers.AnimeMapper;
import app.mappers.dto.AnimeDTO;

import java.util.List;
import java.util.Set;

public class ListAllAnimeController {

    private App app;
    private AnimeMapper mapper;

    public ListAllAnimeController() {
        this.app = App.getInstance();
        this.mapper = new AnimeMapper();
    }

    public List<AnimeDTO> listAllAnime() {
        AnimeStore store = app.getCompany().getAniStore();
        Set<Anime> lst = store.getAll();
        return mapper.toDTO(lst);
    }
}
