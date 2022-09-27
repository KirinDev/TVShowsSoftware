package app.domain.store;

import app.domain.model.Anime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnimeStore {

    private Set<Anime> store = new HashSet<>();

    public Anime create(String name, int aired, String genres, double duration, double score, int num_episodes, String studio, String type) {
        return new Anime(name, aired, genres, duration, score, num_episodes, studio, type);
    }

    public boolean add(Anime anime) {
        return anime != null && !this.exists(anime) ?this.store.add(anime) : false;
    }

    public boolean remove(Anime anime) {
        return anime != null ? this.store.remove(anime) : false;
    }

    public Set<Anime> getAll() {
        return Collections.unmodifiableSet(this.store);
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
                return false;
        }
        return true;
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
