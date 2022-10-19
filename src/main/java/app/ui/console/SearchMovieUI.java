package app.ui.console;

import app.controller.SearchMovieController;
import app.domain.model.Movie;
import app.ui.console.utils.Utils;

public class SearchMovieUI implements Runnable {

    private SearchMovieController ctrl;

    public SearchMovieUI() {
        ctrl = new SearchMovieController();
    }

    public void run() {
        boolean success = false;

        do {
            System.out.println("\n| Searching movie... |");
            String name = Utils.readLineFromConsole("Insert name: ");

            Movie movie = ctrl.searchMovie(name);

            if( movie != null ) {
                System.out.println("\n===================");
                System.out.println("| Name: " + movie.getName());
                System.out.println("| Aired: " + movie.getAired());
                System.out.println("| Genres: " + movie.getGenres());
                System.out.println("| Duration: " + movie.getDuration());
                System.out.println("| Score: " + movie.getScore());
                System.out.println("===================");
                success = true;
            }else{
                System.err.println("»» Error 102: The movie '" + name + "' was not found ««");
            }
        }while(!success);
    }
}
