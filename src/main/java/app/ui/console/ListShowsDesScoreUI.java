package app.ui.console;

import app.controller.ListShowsDesScoreController;
import app.mappers.dto.AnimeDTO;
import app.mappers.dto.MovieDTO;
import app.mappers.dto.SerieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListShowsDesScoreUI implements Runnable {

    private int show;
    private ListShowsDesScoreController ctrl;

    public ListShowsDesScoreUI(int show) {
        this.show = show;
        ctrl = new ListShowsDesScoreController();
    }

    public void run() {

        switch (this.show) {
            case 1 -> {
                System.out.println("\n| List of Animes ordered by score (Descendant) |");
                List<AnimeDTO> ani_lst = ctrl.getOrderedListByScoreDesAnime();
                Utils.printAnimeInfo(ani_lst);
            }
            case 2 -> {
                System.out.println("\n| List of Movies ordered by score (Descendant) |");
                List<MovieDTO> mov_lst = ctrl.getOrderedListByScoreDesMovie();
                Utils.printMovieInfo(mov_lst);
            }
            case 3 -> {
                System.out.println("\n| List of Series ordered by score (Descendant) |");
                List<SerieDTO> ser_lst = ctrl.getOrderedListByScoreDesSeries();
                Utils.printSeriesInfo(ser_lst);
            }
        }
    }
}
