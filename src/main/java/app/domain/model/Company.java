package app.domain.model;

import app.auth.AuthFacade;
import app.domain.store.*;
import org.apache.commons.lang3.StringUtils;

public class Company {

    private String designation;
    private AuthFacade authFacade;

    private TVShowStore tvsStore;
    private AnimeStore aniStore;
    private MovieStore movStore;
    private SeriesStore serStore;
    private CompAnimeStore compAniStore;
    private CompMovieStore compMovStore;
    private CompSerieStore compSerStore;

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();

        this.tvsStore = new TVShowStore();
        this.aniStore = new AnimeStore();
        this.movStore = new MovieStore();
        this.serStore = new SeriesStore();
        this.compAniStore = new CompAnimeStore();
        this.compMovStore = new CompMovieStore();
        this.compSerStore = new CompSerieStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public TVShowStore getTvsStore(){return this.tvsStore;}

    public AnimeStore getAniStore() {
        return this.aniStore;
    }

    public MovieStore getMovStore() {
        return this.movStore;
    }

    public SeriesStore getSerStore() {
        return this.serStore;
    }

    public CompAnimeStore getCompAniStore() {
        return compAniStore;
    }

    public CompMovieStore getCompMovStore() {
        return compMovStore;
    }

    public CompSerieStore getCompSerStore() {
        return compSerStore;
    }
}
