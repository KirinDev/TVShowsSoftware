package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ViewShowsListUI implements Runnable {

    public ViewShowsListUI() { }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("View my anime list " , new ViewAnimeListUI()));
        options.add(new MenuItem("View my movie list " , new ViewMovieListUI()));
        options.add(new MenuItem("View my series list " , new ViewSeriesListUI()));

        int option = 0;
        do {
            try {
                option = Utils.showAndSelectIndex(options, "\n\nUser Menu:");

                if ( (option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            } catch (Exception e){System.out.print("Invalid option! Try again");;}
        }
        while (option != -1 );
    }
}
