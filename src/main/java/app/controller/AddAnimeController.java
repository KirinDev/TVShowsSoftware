package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;
import app.domain.store.CompAnimeStore;

public class AddAnimeController {

    private App app;
    private CompAnimeStore store;
    private AnimeStore aniStore;

    public AddAnimeController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getCompAniStore();
        this.aniStore = app.getCompany().getAniStore();
    }

    public Anime getByName( String name ) {
        return this.aniStore.getByName(name);
    }

    public boolean addAnime( Anime anime ) {
        return this.store.add(anime);
    }
}
