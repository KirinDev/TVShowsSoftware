package app.controller;

import app.domain.model.Serie;
import app.domain.store.SeriesStore;

public class SearchSerieController {

    private App app;

    public SearchSerieController() {
        this.app = App.getInstance();
    }

    public Serie searchSerie(String name) {
        SeriesStore store = this.app.getCompany().getSerStore();
        return store.getByName(name);
    }
}
