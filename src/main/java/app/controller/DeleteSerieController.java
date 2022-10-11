package app.controller;

import app.domain.model.Serie;
import app.domain.store.SerieStore;

import java.util.List;

public class DeleteSerieController {

    private App app;
    private SerieStore store;

    public DeleteSerieController() {
        this.app = App.getInstance();
        this.store = app.getCompany().getSerStore();
    }

    public List<Serie> listAllSerie() {
        this.store = app.getCompany().getSerStore();
        return store.getAll();
    }

    public void delete(Serie serie) {
        this.store.remove(serie);
    }
}
