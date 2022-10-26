package app.ui.console;

import app.controller.ListShowsAscScoreController;
import app.mappers.dto.AnimeDTO;
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
            case 1 :
                List<AnimeDTO> lst = ctrl.getOrderedListByScoreAsc();
                Utils.printAnimeInfo(lst);
                break;

            case 2 :

        }
    }
}
