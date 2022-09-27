package app.mappers;

import app.domain.model.Anime;
import app.mappers.dto.AnimeDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AnimeMapper {

    public AnimeMapper() { }

    public AnimeDTO toDTO(Anime anime) {
        return new AnimeDTO(anime.getName(), anime.getAired(), anime.getGenres(), anime.getDuration(), anime.getScore(),
                anime.getNum_episodes(), anime.getStudio(), anime.getType());
    }

    public List<AnimeDTO> toDTO(List<Anime> animes) {
        List<AnimeDTO> animesDTO = new ArrayList();
        Iterator var3 = animes.iterator();

        while(var3.hasNext()) {
            Anime anime = (Anime) var3.next();
            animesDTO.add(this.toDTO(anime));
        }

        return animesDTO;
    }

    public List<AnimeDTO> toDTO(Set<Anime> animes) {
        List<AnimeDTO> animesDTO = new ArrayList();
        Iterator var3 = animes.iterator();

        while(var3.hasNext()) {
            Anime anime = (Anime) var3.next();
            animesDTO.add(this.toDTO(anime));
        }

        return animesDTO;
    }
}
