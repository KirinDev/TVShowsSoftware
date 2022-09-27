package app.domain.model;

public class Serie extends TVShow {

    private int num_episodes;

    public Serie(String name, int aired, String genres, Double duration, Double score, int num_episodes) {
        super(name, aired, genres, duration, score);
        this.num_episodes = num_episodes;
    }

    public int getNum_episodes() {
        return num_episodes;
    }
}
