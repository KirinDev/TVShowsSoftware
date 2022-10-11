package app.ui.console;

import app.controller.DeleteMovieController;
import app.domain.model.Movie;
import app.ui.console.utils.Utils;

import java.util.List;

public class DeleteMovieUI implements Runnable {

    private DeleteMovieController ctrl;

    public DeleteMovieUI() {
        ctrl = new DeleteMovieController();
    }

    public void run() {
        boolean success = false;
        int option = 0;
        do {
            List<Movie> mov_lst = ctrl.listAllMovie();
            int counter = 1;
            System.out.println("\n| Choose the movie you wish to delete |");

            for(Movie i : mov_lst) {
                System.out.println(counter + ". " + i.getName());
            }

            System.out.println("\n0 - Cancel");
            option = Utils.readIntegerFromConsole("Type your option: ");

            if(option > 0 && option <= mov_lst.size()) {
                ctrl.delete(mov_lst.get(option - 1));
                success = true;
            }else if(option == 0) {
                break;
            }else{
                System.err.println("»» Error 101 : Option Invalid! Please try again ««");
            }
        }while(!success);
    }
}
