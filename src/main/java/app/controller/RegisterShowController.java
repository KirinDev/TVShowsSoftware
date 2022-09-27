package app.controller;

import app.domain.model.TVShow;
import app.domain.store.TVShowStore;

public class RegisterShowController {

    private App app;
    private TVShow show;

    public RegisterShowController() {
        this.app = App.getInstance();
    }

    public void create(String name, int aired, String genres, Double duration, Double score) {
        TVShowStore store = app.getCompany().getTvsStore();
        this.show = store.create(name, aired, genres, duration, score);
    }

    public void save() {
        TVShowStore store = app.getCompany().getTvsStore();
        store.add(show);
    }
}
