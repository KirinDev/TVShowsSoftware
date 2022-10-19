package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;

public class SearchAnimeController {

    private App app;

    public SearchAnimeController() {
        this.app = App.getInstance();
    }

    public Anime searchAnime(String name) {
        AnimeStore store = this.app.getCompany().getAniStore();
        return store.getByName(name);
    }
}
