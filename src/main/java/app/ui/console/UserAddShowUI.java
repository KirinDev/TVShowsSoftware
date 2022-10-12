package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserAddShowUI implements Runnable {

    public UserAddShowUI() { }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Add anime " , new UserAddAnimeUI()));
        options.add(new MenuItem("Add movie " , new UserAddMovieUI()));
        options.add(new MenuItem("Add serie " , new UserAddSerieUI()));

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
