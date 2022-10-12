package app.ui.console;

import app.controller.AddAnimeController;
import app.domain.model.Anime;
import app.ui.console.utils.Utils;

public class UserAddAnimeUI implements Runnable {

    private AddAnimeController ctrl;

    public UserAddAnimeUI() {
        ctrl = new AddAnimeController();
    }

    public void run() {
        boolean success = false;

        do {
            String name = Utils.readLineFromConsole("\nInsert name of anime: ");
            System.out.println("\n0 - Cancel");

            Anime anime = ctrl.getByName(name);

            if(name.equals("0"))
                break;

            if( anime != null) {
                if(ctrl.addAnime(anime)) {
                    System.out.println("*The anime '" + name + "' was added successfully to your list*");
                    success = true;
                }else{
                    System.err.println("»» Error 404: The anime '" + name + "' already exist in your list ««");
                }
            }else{
                System.err.println("»» Error 404: The anime '" + name + "' was not found! ««");
            }
        }while(!success);
    }
}
