package app.mappers.dto;

public class MovieDTO extends TVShowDTO {

    public MovieDTO(String name, int aired, String genres, Double duration, Double score) {
        super(name, aired, genres, duration, score);
    }
}
