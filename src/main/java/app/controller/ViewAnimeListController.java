package app.controller;

import app.domain.model.Anime;
import app.domain.store.CompAnimeStore;
import app.mappers.AnimeMapper;
import app.mappers.dto.AnimeDTO;

import java.util.List;

public class ViewAnimeListController {

    private App app;
    private AnimeMapper mapper;

    public ViewAnimeListController() {
        this.app = App.getInstance();
        this.mapper = new AnimeMapper();
    }

    public List<AnimeDTO> getAllAnime() {
        CompAnimeStore store = this.app.getCompany().getCompAniStore();
        List<Anime> lst = store.getAll();
        return this.mapper.toDTO(lst);
    }
}
