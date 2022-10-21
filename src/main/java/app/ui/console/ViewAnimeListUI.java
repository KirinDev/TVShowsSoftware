package app.ui.console;

import app.controller.ViewAnimeListController;
import app.mappers.dto.AnimeDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ViewAnimeListUI implements Runnable {

    private ViewAnimeListController ctrl;

    public ViewAnimeListUI() {
        ctrl = new ViewAnimeListController();
    }

    public void run() {
        System.out.println("| My Anime List |");
        List<AnimeDTO> lst = ctrl.getAllAnime();
        if( lst.size() > 0 ) {
            Utils.printAnimeInfo(lst);
        }else{
            System.out.println("\n* Your anime list is empty *");
        }
    }
}
