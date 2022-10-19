package app.controller;

import app.domain.model.Serie;
import app.domain.store.SerieStore;

public class SearchSerieController {

    private App app;

    public SearchSerieController() {
        this.app = App.getInstance();
    }

    public Serie searchSerie(String name) {
        SerieStore store = this.app.getCompany().getSerStore();
        return store.getByName(name);
    }
}
