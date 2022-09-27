package app.mappers;

import app.domain.model.Movie;
import app.mappers.dto.MovieDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MovieMapper {

    public MovieMapper() { }

    public MovieDTO toDTO(Movie movie) {
        return new MovieDTO(movie.getName(), movie.getAired(), movie.getGenres(), movie.getDuration(), movie.getScore());
    }

    public List<MovieDTO> toDTO(List<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList();
        Iterator var3 = movies.iterator();

        while(var3.hasNext()) {
            Movie movie = (Movie) var3.next();
            moviesDTO.add(this.toDTO(movie));
        }

        return moviesDTO;
    }

    public List<MovieDTO> toDTO(Set<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList();
        Iterator var3 = movies.iterator();

        while(var3.hasNext()) {
            Movie movie = (Movie) var3.next();
            moviesDTO.add(this.toDTO(movie));
        }

        return moviesDTO;
    }
}
