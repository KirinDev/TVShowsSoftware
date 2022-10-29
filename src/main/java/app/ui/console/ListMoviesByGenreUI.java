package app.ui.console;

import app.controller.ListShowsByGenreController;
import app.mappers.dto.MovieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListMoviesByGenreUI implements Runnable {

    private ListShowsByGenreController ctrl;
    private int type_genre;

    public ListMoviesByGenreUI(int type_genre) {
        ctrl = new ListShowsByGenreController();
        this.type_genre = type_genre;
    }

    public void run() {

        switch (this.type_genre) {

            case 1 -> {
                System.out.println("\n| List of Movies of action genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Action");
                Utils.printMovieInfo(lst);
            }

            case 2 -> {
                System.out.println("\n| List of Movies of comedy genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Comedy");
                Utils.printMovieInfo(lst);
            }

            case 3 -> {
                System.out.println("\n| List of Movies of drama genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Drama");
                Utils.printMovieInfo(lst);
            }

            case 4 -> {
                System.out.println("\n| List of Movies of fantasy genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Fantasy");
                Utils.printMovieInfo(lst);
            }

            case 5 -> {
                System.out.println("\n| List of Movies of horror genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Action");
                Utils.printMovieInfo(lst);
            }

            case 6 -> {
                System.out.println("\n| List of Movies of mystery genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Mystery");
                Utils.printMovieInfo(lst);
            }

            case 7 -> {
                System.out.println("\n| List of Movies of romance genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Romance");
                Utils.printMovieInfo(lst);
            }

            case 8 -> {
                System.out.println("\n| List of Movies of thriller genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Action");
                Utils.printMovieInfo(lst);
            }

            case 9 -> {
                System.out.println("\n| List of Movies of western genre |");
                List<MovieDTO> lst = ctrl.getMovieListByGenre("Western");
                Utils.printMovieInfo(lst);
            }
        }
    }
}
