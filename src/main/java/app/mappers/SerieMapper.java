package app.mappers;

import app.domain.model.Serie;
import app.mappers.dto.SerieDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SerieMapper {

    public SerieMapper() { }

    public SerieDTO toDTO(Serie serie) {
        return new SerieDTO(serie.getName(), serie.getAired(), serie.getGenres(), serie.getDuration(), serie.getScore());
    }

    public List<SerieDTO> toDTO(List<Serie> series) {
        List<SerieDTO> seriesDTO = new ArrayList();
        Iterator var3 = series.iterator();

        while(var3.hasNext()) {
            Serie serie = (Serie) var3.next();
            seriesDTO.add(this.toDTO(serie));
        }

        return seriesDTO;
    }

    public List<SerieDTO> toDTO(Set<Serie> series) {
        List<SerieDTO> seriesDTO = new ArrayList();
        Iterator var3 = series.iterator();

        while(var3.hasNext()) {
            Serie serie = (Serie) var3.next();
            seriesDTO.add(this.toDTO(serie));
        }

        return seriesDTO;
    }
}
