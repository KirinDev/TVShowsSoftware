package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class TVShow {

    private String name;
    private int aired;
    private String genres;
    private double duration;
    private double score;

    public TVShow(String name, int aired, String genres, Double duration, Double score) {
        if( StringUtils.isBlank(name) && StringUtils.isBlank(genres)) {
            throw new IllegalArgumentException( "TVShow cannot have values as null/blank!!!" );
        }
        this.name = name;
        this.aired = aired;
        this.genres = genres;
        this.duration = duration;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAired() {
        return aired;
    }

    public String getGenres() {
        return genres;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getScore() {
        return score;
    }

    public boolean checkDuration( double duration ) {
        return true;
    }

    public boolean checkScore( double score ) {
        return true;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "name='" + name + '\'' +
                ", aired='" + aired + '\'' +
                ", genres='" + genres + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
