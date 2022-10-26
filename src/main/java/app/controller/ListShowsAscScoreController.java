package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;
import app.mappers.AnimeMapper;
import app.mappers.dto.AnimeDTO;

import java.util.List;

public class ListShowsAscScoreController {

    private App app;
    private AnimeMapper mapper;

    public ListShowsAscScoreController() {
        this.app = App.getInstance();
    }

    public List<AnimeDTO> getOrderedListByScoreAsc() {
        AnimeStore store = this.app.getCompany().getAniStore();
        List<Anime> lst = store.orderAscByScore();
        return mapper.toDTO(lst);
    }
}
