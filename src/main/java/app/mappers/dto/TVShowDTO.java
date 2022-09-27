package app.mappers.dto;

public class TVShowDTO {

    private String name;
    private int aired;
    private String genres;
    private double duration;
    private double score;

    public TVShowDTO(String name, int aired, String genres, Double duration, Double score) {
        this.name = name;
        this.aired = aired;
        this.genres = genres;
        this.duration = duration;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getAired() {
        return this.aired;
    }

    public String getGenres() {
        return this.genres;
    }

    public double getDuration() {
        return this.duration;
    }

    public double getScore() {
        return this.score;
    }
}
