package app.domain.store;

import app.domain.model.Serie;

import java.util.ArrayList;
import java.util.List;

public class CompSerieStore {

    private List<Serie> store = new ArrayList<>();

    public CompSerieStore() { }

    public boolean add(Serie serie) {
        return serie != null && !this.exists(serie) ?this.store.add(serie) : false;
    }

    public boolean remove(Serie serie) {
        return serie != null ? this.store.remove(serie) : false;
    }

    public List<Serie> getAll() {
        return this.store;
    }

    public boolean exists( Serie serie ) {

        for (Serie i : this.store) {
            if (i.getName().equals(serie.getName()))
                return true;
        }
        return false;
    }
}
