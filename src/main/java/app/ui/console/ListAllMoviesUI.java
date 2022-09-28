package app.ui.console;

import app.controller.ListAllMoviesController;
import app.mappers.dto.MovieDTO;

import java.util.List;

public class ListAllMoviesUI implements Runnable {

    private ListAllMoviesController ctrl;

    public ListAllMoviesUI() {
        ctrl = new ListAllMoviesController();
    }

    public void run() {

        List<MovieDTO> mov_lst = ctrl.listAllMovies();
        System.out.println("\n| List of all movies |");
        for(MovieDTO i : mov_lst) {
            System.out.println("===================");
            System.out.println("Name: " + i.getName());
            System.out.println("Aired: " + i.getAired());
            System.out.println("Genres: " + i.getGenres());
            System.out.println("Duration: " + i.getDuration());
            System.out.println("Score: " + i.getScore());
            System.out.println("===================");
        }

    }
}
