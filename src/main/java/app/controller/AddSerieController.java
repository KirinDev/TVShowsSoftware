package app.controller;

import app.domain.model.Serie;
import app.domain.store.CompSerieStore;
import app.domain.store.SeriesStore;

public class AddSerieController {

    private App app;
    private CompSerieStore store;
    private SeriesStore serStore;

    public AddSerieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getCompSerStore();
        this.serStore = app.getCompany().getSerStore();
    }

    public Serie getByName(String name ) {
        return this.serStore.getByName(name);
    }

    public boolean addSerie( Serie serie ) {
        return this.store.add(serie);
    }
}
