package app.ui.console;

import app.controller.ListAllAnimeController;
import app.mappers.dto.AnimeDTO;

import java.util.List;

public class ListAllAnimeUI implements Runnable {

    private ListAllAnimeController ctrl;

    public ListAllAnimeUI() {
        ctrl = new ListAllAnimeController();
    }

    public void run() {

        List<AnimeDTO> ani_lst = ctrl.listAllAnime();
        System.out.println("\n| List of all animes |");
        for(AnimeDTO i : ani_lst) {
            System.out.println("===================");
            System.out.println("Name: " + i.getName());
            System.out.println("Aired: " + i.getAired());
            System.out.println("Genres: " + i.getGenres());
            System.out.println("Studio: " + i.getStudio());
            System.out.println("Type: " + i.getType());
            System.out.println("Duration: " + i.getDuration());
            System.out.println("Score: " + i.getScore());
            System.out.println("Number of episodes: " + i.getNum_episodes());
            System.out.println("===================");
        }

    }
}
