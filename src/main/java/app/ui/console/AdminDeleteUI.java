package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AdminDeleteUI implements Runnable {

    public AdminDeleteUI() { }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Delete a anime " , new DeleteAnimeUI() ));
        options.add(new MenuItem("Delete a movie " , new DeleteMovieUI() ));
        options.add(new MenuItem("Delete a serie " , new DeleteSerieUI() ));

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
