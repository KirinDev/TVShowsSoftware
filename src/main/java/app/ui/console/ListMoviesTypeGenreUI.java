package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesTypeGenreUI implements Runnable {

    public ListMoviesTypeGenreUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Action " , new ListAnimesByGenreUI(1) ));
        options.add(new MenuItem("Comedy " , new ListAnimesByGenreUI(2) ));
        options.add(new MenuItem("Drama " , new ListAnimesByGenreUI(3) ));
        options.add(new MenuItem("Fantasy " , new ListAnimesByGenreUI(4) ));
        options.add(new MenuItem("Horror " , new ListAnimesByGenreUI(5) ));
        options.add(new MenuItem("Mystery " , new ListAnimesByGenreUI(6) ));
        options.add(new MenuItem("Romance " , new ListAnimesByGenreUI(7) ));
        options.add(new MenuItem("Thriller " , new ListAnimesByGenreUI(8) ));
        options.add(new MenuItem("Western " , new ListAnimesByGenreUI(9) ));

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
