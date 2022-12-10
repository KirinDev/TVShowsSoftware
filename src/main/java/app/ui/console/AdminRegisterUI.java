package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AdminRegisterUI implements Runnable {

    public AdminRegisterUI() { }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new anime " , new RegisterAnimeUI() ));
        options.add(new MenuItem("Register a new movie " , new RegisterMovieUI() ));
        options.add(new MenuItem("Register a new series " , new RegisterSerieUI() ));
        options.add(new MenuItem("Add all anime through API " , new RegisterAPIAnimesUI() ));

        int option = 0;
        do {
            try {
                option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

                if ( (option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            } catch (Exception e){System.out.print("Invalid option! Try again");;}
        }
        while (option != -1 );
    }
}
