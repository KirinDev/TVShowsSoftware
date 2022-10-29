package app.controller;

import app.domain.model.Serie;
import app.domain.store.SeriesStore;

public class RegisterSerieController {

    private App app;
    private Serie serie;
    private SeriesStore store;

    public RegisterSerieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getSerStore();
    }

    public boolean create(String name, int aired, String genres, double duration, double score, int num_episodes) {
        this.serie = this.store.create(name, aired, genres, duration, score, num_episodes);
        return store.validate(serie);
    }

    public boolean save() {
        return store.save(serie);
    }
}
