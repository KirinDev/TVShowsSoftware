package app.mappers.dto;

public class SerieDTO extends TVShowDTO {

    private int num_episodes;

    public SerieDTO(String name, int aired, String genres, Double duration, Double score) {
        super(name, aired, genres, duration, score);
    }

    public int getNum_episodes() {
        return this.num_episodes;
    }
}
