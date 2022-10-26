package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserListShowsUI implements Runnable {

    public UserListShowsUI() { }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Show all animes " , new ListAnimeTypeOrderUI() ));
        options.add(new MenuItem("Show all movies " , new ListMovieTypeOrderUI() ));
        options.add(new MenuItem("Show all series " , new ListSeriesTypeOrderUI() ));

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
