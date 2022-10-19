package app.ui.console;

import app.controller.SearchAnimeController;
import app.domain.model.Anime;
import app.ui.console.utils.Utils;

public class SearchAnimeUI implements Runnable {

    private SearchAnimeController ctrl;

    public SearchAnimeUI() {
        ctrl = new SearchAnimeController();
    }

    public void run() {
        boolean success = false;

        do {
            System.out.println("\n| Searching anime... |");
            String name = Utils.readLineFromConsole("Insert name: ");


            Anime anime = ctrl.searchAnime(name);

            if( anime != null ) {
                System.out.println("\n===================");
                System.out.println("| Name: " + anime.getName());
                System.out.println("| Aired: " + anime.getAired());
                System.out.println("| Genres: " + anime.getGenres());
                System.out.println("| Studio: " + anime.getStudio());
                System.out.println("| Type: " + anime.getType());
                System.out.println("| Duration: " + anime.getDuration());
                System.out.println("| Score: " + anime.getScore());
                System.out.println("| Number of episodes: " + anime.getNum_episodes());
                System.out.println("===================");
                success = true;
            }else{
                System.err.println("»» Error 102: The anime '" + name + "' was not found ««");
            }
        }while(!success);
    }
}
