package app.ui.console;

import app.controller.ListShowsAscScoreController;
import app.mappers.dto.AnimeDTO;
import app.mappers.dto.MovieDTO;
import app.mappers.dto.SerieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListShowsAscScoreUI implements Runnable {

    private int show;
    private ListShowsAscScoreController ctrl;

    public ListShowsAscScoreUI(int show) {
        ctrl = new ListShowsAscScoreController();
        this.show = show;
    }

    public void run() {

        switch (this.show) {
            case 1 -> {
                System.out.println("\n| List of Animes ordered by score (Ascendant) |");
                List<AnimeDTO> ani_lst = ctrl.getOrderedListByScoreAscAnime();
                Utils.printAnimeInfo(ani_lst);
            }
            case 2 -> {
                System.out.println("\n| List of Movies ordered by score (Ascendant) |");
                List<MovieDTO> mov_lst = ctrl.getOrderedListByScoreAscMovie();
                Utils.printMovieInfo(mov_lst);
            }
            case 3 -> {
                System.out.println("\n| List of Series ordered by score (Ascendant) |");
                List<SerieDTO> ser_lst = ctrl.getOrderedListByScoreAscSeries();
                Utils.printSeriesInfo(ser_lst);
            }
        }
    }
}
