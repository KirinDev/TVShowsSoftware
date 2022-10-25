package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListAnimeTypeOrderUI implements Runnable {

    public ListAnimeTypeOrderUI() {

    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Random " , new ListAllAnimeUI() ));
        options.add(new MenuItem("By Score " , new ListAnimeAscOrDesUI() ));

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
