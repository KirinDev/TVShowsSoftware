package app.ui.console;

import app.controller.ListShowsByGenreController;
import app.mappers.dto.AnimeDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListAnimesByGenreUI implements Runnable {

    private ListShowsByGenreController ctrl;
    private int type_genre;

    public ListAnimesByGenreUI(int type_genre) {
        ctrl = new ListShowsByGenreController();
        this.type_genre = type_genre;
    }

    public void run() {

        switch(this.type_genre) {

            case 1 -> {
                System.out.println("\n| List of Animes of action genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Action");
                Utils.printAnimeInfo(lst);
            }

            case 2 -> {
                System.out.println("\n| List of Animes of adventure genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Adventure");
                Utils.printAnimeInfo(lst);
            }

            case 3 -> {
                System.out.println("\n| List of Animes of comedy genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Comedy");
                Utils.printAnimeInfo(lst);
            }

            case 4 -> {
                System.out.println("\n| List of Animes of drama genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Drama");
                Utils.printAnimeInfo(lst);
            }

            case 5 -> {
                System.out.println("\n| List of Animes of horror genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Horror");
                Utils.printAnimeInfo(lst);
            }

            case 6 -> {
                System.out.println("\n| List of Animes of fantasy genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Fantasy");
                Utils.printAnimeInfo(lst);
            }

            case 7 -> {
                System.out.println("\n| List of Animes of romance genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Romance");
                Utils.printAnimeInfo(lst);
            }

            case 8 -> {
                System.out.println("\n| List of Animes of slice of life genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Slice of Life");
                Utils.printAnimeInfo(lst);
            }

            case 9 -> {
                System.out.println("\n| List of Animes of sports genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Sports");
                Utils.printAnimeInfo(lst);
            }

            case 10 -> {
                System.out.println("\n| List of Animes of supernatural genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Supernatural");
                Utils.printAnimeInfo(lst);
            }

            case 11 -> {
                System.out.println("\n| List of Animes of sci-fi genre |");
                List<AnimeDTO> lst = ctrl.getAnimeListByGenre("Sci-Fi");
                Utils.printAnimeInfo(lst);
            }
        }
    }
}
