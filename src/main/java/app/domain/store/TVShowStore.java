package app.domain.store;

import app.domain.model.TVShow;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TVShowStore {

    private Set<TVShow> store = new HashSet<>();

    public TVShow create(String name, int aired, String genres, Double duration, Double score) {
        return new TVShow(name, aired, genres, duration, score);
    }

    public boolean add(TVShow show) {
        return show != null && !this.exists(show) ?this.store.add(show) : false;
    }

    public boolean remove(TVShow show) {
        return show != null ? this.store.remove(show) : false;
    }

    public Set<TVShow> getAll() {
        return Collections.unmodifiableSet(this.store);
    }

    public boolean exists( TVShow show ) {

        for (TVShow i : this.store) {
            if (i.getName().equals(show.getName()))
                return false;
        }
        return true;
    }
}
