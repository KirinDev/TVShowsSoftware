package app.ui.console;

import app.controller.SearchAnimeController;
import app.domain.model.Anime;
import app.ui.console.utils.Utils;
import org.json.JSONObject;

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

            JSONObject data = ctrl.searchAnime(name);

            if( data != null ) {
                System.out.println("\n===================");
                System.out.println("| Title: " + data.getString("canonicalTitle"));
                System.out.println("| Aired: " + data.getString("startDate"));
                System.out.println("| Type: " + data.getString("subtype"));
                System.out.println("| Duration: " + data.getInt("episodeLength"));
                System.out.println("| Average Score: " + data.getString("averageRating"));
                System.out.println("| Number of episodes: " + data.getInt("episodeCount"));
                System.out.println("| Synopsis: " + "\n"+data.getString("synopsis"));
                System.out.println("===================");
                success = true;
            }else{
                System.err.println("»» Error 102: The anime '" + name + "' was not found ««");
            }
        }while(!success);
    }
}
