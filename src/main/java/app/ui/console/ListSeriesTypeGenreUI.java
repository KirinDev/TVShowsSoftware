package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListSeriesTypeGenreUI implements Runnable {

    public ListSeriesTypeGenreUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Action " , new ListSeriesByGenreUI(1) ));
        options.add(new MenuItem("Comedy " , new ListSeriesByGenreUI(2) ));
        options.add(new MenuItem("Drama " , new ListSeriesByGenreUI(3) ));
        options.add(new MenuItem("Fantasy " , new ListSeriesByGenreUI(4) ));
        options.add(new MenuItem("Horror " , new ListSeriesByGenreUI(5) ));
        options.add(new MenuItem("Mystery " , new ListSeriesByGenreUI(6) ));
        options.add(new MenuItem("Romance " , new ListSeriesByGenreUI(7) ));
        options.add(new MenuItem("Thriller " , new ListSeriesByGenreUI(8) ));
        options.add(new MenuItem("Western " , new ListSeriesByGenreUI(9) ));

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
