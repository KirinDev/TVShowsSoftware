package app.ui.console;

import app.controller.SearchSerieController;
import app.domain.model.Serie;
import app.ui.console.utils.Utils;

public class SearchSerieUI implements Runnable {

    private SearchSerieController ctrl;

    public SearchSerieUI() {
        ctrl = new SearchSerieController();
    }

    public void run() {
        boolean success = false;

        do {
            System.out.println("\n| Searching serie... |");
            String name = Utils.readLineFromConsole("Insert name: ");

            Serie serie = ctrl.searchSerie(name);

            if( serie != null ) {
                System.out.println("\n===================");
                System.out.println("| Name: " + serie.getName());
                System.out.println("| Aired: " + serie.getAired());
                System.out.println("| Genres: " + serie.getGenres());
                System.out.println("| Duration: " + serie.getDuration());
                System.out.println("| Score: " + serie.getScore());
                System.out.println("| Number of episodes: " + serie.getNum_episodes());
                System.out.println("===================");
                success = true;
            }else{
                System.err.println("»» Error 102: The serie '" + name + "' was not found ««");
            }
        }while(!success);
    }
}
