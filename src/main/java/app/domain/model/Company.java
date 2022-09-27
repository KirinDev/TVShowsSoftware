package app.domain.model;

import app.auth.AuthFacade;
import app.domain.store.AnimeStore;
import app.domain.store.MovieStore;
import app.domain.store.SerieStore;
import app.domain.store.TVShowStore;
import org.apache.commons.lang3.StringUtils;

public class Company {

    private String designation;
    private AuthFacade authFacade;

    private TVShowStore tvsStore;
    private AnimeStore aniStore;
    private MovieStore movStore;
    private SerieStore serStore;

    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();

        this.tvsStore = new TVShowStore();
        this.aniStore = new AnimeStore();
        this.movStore = new MovieStore();
        this.serStore = new SerieStore();
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

    public SerieStore getSerStore() {
        return this.serStore;
    }
}
