package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;

import java.util.Set;

public class RegisterAnimeController {

    private App app;
    private Anime anime;
    private AnimeStore store;

    public RegisterAnimeController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getAniStore();
    }

    public boolean create(String name, int aired, String genres, double duration, double score, int num_episodes, String studio, String type) {
        this.anime = this.store.create(name, aired, genres, duration, score, num_episodes, studio, type);
        return store.validate(anime);
    }

    public boolean save() {
        return store.save(anime);
    }

}
