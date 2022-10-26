package app.domain.store;

import app.domain.model.Anime;

import java.util.*;

public class AnimeStore {

    private List<Anime> store = new ArrayList<>();

    public AnimeStore() { }

    public Anime create(String name, int aired, String genres, double duration, double score, int num_episodes, String studio, String type) {
        return new Anime(name, aired, genres, duration, score, num_episodes, studio, type);
    }

    public boolean add(Anime anime) {
        return anime != null && !this.exists(anime) ? this.store.add(anime) : false;
    }

    public boolean remove(Anime anime) {
        return anime != null ? this.store.remove(anime) : false;
    }

    public List<Anime> getAll() {
        return this.store;
    }

    public boolean validate(Anime anime) {
        return checkAired(anime.getAired()) && checkDuration(anime.getDuration()) && checkType(anime.getType())
                && checkNumEps(anime.getNum_episodes()) && checkScore(anime.getScore());
    }

    public boolean save(Anime anime) {
        if( validate(anime) ) {
            add(anime);
            return true;
        }else{
            return false;
        }
    }

    public boolean exists( Anime anime ) {

        for (Anime i : this.store) {
            if (i.getName().equals(anime.getName()))
                return true;
        }
        return false;
    }

    public Anime getByName( String name ) {
        for (Anime i : this.store) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    public List<Anime> orderAscByScore() {
        List<Anime> orig_lst = this.store;
        List<Anime> ord_lst = new ArrayList<>();

        while(ord_lst.size() != this.store.size()) {
            double min = 11;
            Anime anime = null;
            
            for(Anime i : orig_lst) {
                if( i.getScore() < min) {
                    anime = i;
                    min = i.getScore();
                }
            }
            ord_lst.add(anime);
        }
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

    public boolean checkType( String type ) {
        return type.equals("serie") || type.equals("movie");
    }

}
