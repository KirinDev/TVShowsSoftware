package app.controller;

import app.domain.model.Anime;
import app.domain.store.AnimeStore;

public class RegisterAnimeController {

    private App app;
    private Anime anime;

    public RegisterAnimeController() {
        this.app = App.getInstance();
    }

    public boolean create(String name, int aired, String genres, Double duration, Double score, int num_episodes, String studio, String type) {
        AnimeStore store = app.getCompany().getAniStore();
        this.anime = store.create(name, aired, genres, duration, score, num_episodes, studio, type);
        return store.validate(anime);
    }

    public boolean save() {
        AnimeStore store = app.getCompany().getAniStore();
        return store.save(anime);
    }
}
