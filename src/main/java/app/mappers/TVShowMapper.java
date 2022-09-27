package app.mappers;

import app.domain.model.TVShow;
import app.mappers.dto.TVShowDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TVShowMapper {

    public TVShowMapper() { }

    public TVShowDTO toDTO(TVShow show) {
        return new TVShowDTO(show.getName(), show.getAired(), show.getGenres(), show.getDuration(), show.getScore());
    }

    public List<TVShowDTO> toDTO(List<TVShow> shows) {
        List<TVShowDTO> showsDTO = new ArrayList();
        Iterator var3 = shows.iterator();

        while(var3.hasNext()) {
            TVShow show = (TVShow) var3.next();
            showsDTO.add(this.toDTO(show));
        }

        return showsDTO;
    }

    public List<TVShowDTO> toDTO(Set<TVShow> shows) {
        List<TVShowDTO> showsDTO = new ArrayList();
        Iterator var3 = shows.iterator();

        while(var3.hasNext()) {
            TVShow show = (TVShow) var3.next();
            showsDTO.add(this.toDTO(show));
        }

        return showsDTO;
    }
}
