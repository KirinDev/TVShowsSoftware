package app.domain.store;

import app.domain.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class CompAnimeStore {

    private List<Anime> store = new ArrayList<>();

    public CompAnimeStore() { }

    public boolean add(Anime anime) {
        return anime != null && !this.exists(anime) ? this.store.add(anime) : false;
    }

    public boolean remove(Anime anime) {
        return anime != null ? this.store.remove(anime) : false;
    }

    public List<Anime> getAll() {
        return this.store;
    }

    public boolean exists( Anime anime ) {

        for (Anime i : this.store) {
            if (i.getName().equals(anime.getName()))
                return true;
        }
        return false;
    }
}
