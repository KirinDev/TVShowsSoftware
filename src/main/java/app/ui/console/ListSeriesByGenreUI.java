package app.ui.console;

import app.controller.ListShowsByGenreController;
import app.mappers.dto.MovieDTO;
import app.mappers.dto.SerieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListSeriesByGenreUI implements Runnable {

    private ListShowsByGenreController ctrl;
    private int type_genre;

    public ListSeriesByGenreUI(int type_genre) {
        ctrl = new ListShowsByGenreController();
        this.type_genre = type_genre;
    }

    public void run() {

        switch (this.type_genre) {

            case 1 -> {
                System.out.println("\n| List of Series of action genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Action");
                Utils.printSeriesInfo(lst);
            }

            case 2 -> {
                System.out.println("\n| List of Series of comedy genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Comedy");
                Utils.printSeriesInfo(lst);
            }

            case 3 -> {
                System.out.println("\n| List of Series of drama genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Drama");
                Utils.printSeriesInfo(lst);
            }

            case 4 -> {
                System.out.println("\n| List of Series of fantasy genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Fantasy");
                Utils.printSeriesInfo(lst);
            }

            case 5 -> {
                System.out.println("\n| List of Series of horror genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Action");
                Utils.printSeriesInfo(lst);
            }

            case 6 -> {
                System.out.println("\n| List of Series of mystery genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Mystery");
                Utils.printSeriesInfo(lst);
            }

            case 7 -> {
                System.out.println("\n| List of Series of romance genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Romance");
                Utils.printSeriesInfo(lst);
            }

            case 8 -> {
                System.out.println("\n| List of Series of thriller genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Action");
                Utils.printSeriesInfo(lst);
            }

            case 9 -> {
                System.out.println("\n| List of Series of western genre |");
                List<SerieDTO> lst = ctrl.getSeriesListByGenre("Western");
                Utils.printSeriesInfo(lst);
            }
        }
    }
}
