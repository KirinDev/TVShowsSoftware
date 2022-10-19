package app.ui.console;

import app.controller.AddMovieController;
import app.domain.model.Movie;
import app.ui.console.utils.Utils;

public class UserAddMovieUI implements Runnable {

    private AddMovieController ctrl;

    public UserAddMovieUI() {
        ctrl = new AddMovieController();
    }

    public void run() {
        boolean success = false;

        do {
            String name = Utils.readLineFromConsole("\nInsert name of the movie: ");
            System.out.println("\n0 - Cancel");

            Movie movie = ctrl.getByName(name);

            if(name.equals("0"))
                break;

            if( movie != null) {
                if(ctrl.addMovie(movie)) {
                    System.out.println("*The movie '" + name + "' was added successfully to your list*");
                    success = true;
                }else{
                    System.err.println("»» Error 404: The movie '" + name + "' already exist in your list ««");
                }
            }else{
                System.err.println("»» Error 404: The movie '" + name + "' was not found! ««");
            }
        }while(!success);
    }
}
