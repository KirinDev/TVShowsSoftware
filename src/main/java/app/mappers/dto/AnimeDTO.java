package app.mappers.dto;

public class AnimeDTO extends TVShowDTO {

    private int num_episodes;
    private String studio;
    private String type;

    public AnimeDTO(String name, int aired, String genres, Double duration, Double score, int num_episodes, String studio, String type) {
        super(name, aired, genres, duration, score);
        this.num_episodes = num_episodes;
        this.studio = studio;
        this.type = type;
    }

    public int getNum_episodes() {
        return this.num_episodes;
    }

    public String getStudio() {
        return this.studio;
    }

    public String getType() {
        return this.type;
    }
}
