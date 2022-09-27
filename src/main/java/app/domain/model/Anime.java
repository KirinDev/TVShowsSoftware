package app.domain.model;

public class Anime extends TVShow {

    private int num_episodes;
    private String studio;
    private String type;

    public Anime(String name, int aired, String genres, double duration, double score, int num_episodes, String studio, String type) {
        super(name, aired, genres, duration, score);
        this.num_episodes = num_episodes;
        this.studio = studio;
        this.type = type;
    }

    public int getNum_episodes() {
        return num_episodes;
    }

    public String getStudio() {
        return studio;
    }

    public String getType() {
        return type;
    }
}
