package app.domain.store;

import app.domain.model.Serie;

import java.util.*;

public class SerieStore {

    private List<Serie> store = new ArrayList<>();

    public SerieStore() { }

    public Serie create(String name, int aired, String genres, Double duration, Double score, int num_episodes) {
        return new Serie(name, aired, genres, duration, score, num_episodes);
    }

    public boolean add(Serie serie) {
        return serie != null && !this.exists(serie) ?this.store.add(serie) : false;
    }

    public boolean remove(Serie serie) {
        return serie != null ? this.store.remove(serie) : false;
    }

    public List<Serie> getAll() {
        return this.store;
    }

    public boolean validate(Serie serie) {
        return checkAired(serie.getAired()) && checkDuration(serie.getDuration())
                && checkNumEps(serie.getNum_episodes()) && checkScore(serie.getScore());
    }

    public boolean save(Serie serie) {
        if( validate(serie) ) {
            add(serie);
            return true;
        }else{
            return false;
        }
    }

    public boolean exists( Serie serie ) {

        for (Serie i : this.store) {
            if (i.getName().equals(serie.getName()))
                return true;
        }
        return false;
    }

    public boolean checkAired( int aired ) {
        return aired >= 1900 && aired <= 2023;
    }

    public boolean checkDuration( double duration ) {
        return duration > 0;
    }

    public boolean checkScore( double score ) {
        return score >= 0 && score <= 10;
    }

    public boolean checkNumEps( int num_episodes ) {
        return num_episodes > 0;
    }
}
