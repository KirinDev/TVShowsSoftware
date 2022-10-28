package app.domain.store;

import app.domain.model.Anime;
import app.domain.model.Movie;
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

    public Serie getByName(String name ) {
        for (Serie i : this.store) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    public List<Serie> orderAscByScore() {
        List<Serie> orig_lst = this.store;
        List<Serie> ord_lst = new ArrayList<>();

        do {
            double min = 11;
            int count = 0;
            int index = 0;
            Serie serie = null;

            for(Serie i : orig_lst) {

                if( i.getScore() < min) {
                    serie = i;
                    min = i.getScore();
                    index = count;
                }
                count++;
            }
            ord_lst.add(serie);
            orig_lst.remove(index);

        }while(ord_lst.size() < this.store.size() + 1);

        return ord_lst;
    }

    public List<Serie> orderDesByScore() {
        List<Serie> orig_lst = this.store;
        List<Serie> ord_lst = new ArrayList<>();

        do {
            double max = 0;
            int count = 0;
            int index = 0;
            Serie serie = null;

            for(Serie i : orig_lst) {

                if( i.getScore() > max) {
                    serie = i;
                    max = i.getScore();
                    index = count;
                }
                count++;
            }
            ord_lst.add(serie);
            orig_lst.remove(index);

        }while(ord_lst.size() < this.store.size() + 1);

        return ord_lst;
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
