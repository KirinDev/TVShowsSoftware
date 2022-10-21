package app.ui.console;

import app.controller.ViewMovieListController;
import app.mappers.dto.MovieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ViewMovieListUI implements Runnable {

    private ViewMovieListController ctrl;

    public ViewMovieListUI() {
        ctrl = new ViewMovieListController();
    }

    public void run() {
        System.out.println("| My Movie List |");
        List<MovieDTO> lst = ctrl.getAllMovies();
        if( lst.size() > 0 ) {
            Utils.printMovieInfo(lst);
        }else{
            System.out.println("\n* Your movie list is empty *");
        }
    }
}
