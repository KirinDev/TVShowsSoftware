package app.ui.console;

import app.controller.DeleteAnimeController;
import app.domain.model.Anime;
import app.mappers.dto.AnimeDTO;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Set;

public class DeleteAnimeUI implements Runnable {

    private DeleteAnimeController ctrl;

    public DeleteAnimeUI() {
        ctrl = new DeleteAnimeController();
    }

    public void run() {

        boolean success = false;
        int option = 0;
        do {
            List<Anime> ani_lst = ctrl.listAllAnime();
            int counter = 1;
            System.out.println("\n| Choose the anime you wish to delete |");

            for(Anime i : ani_lst) {
                System.out.println(counter + ". " + i.getName());
            }
            System.out.println("\n0 - Cancel");
            option = Utils.readIntegerFromConsole("Type your option: ");

            if(option > 0 && option <= ani_lst.size()) {
                ctrl.delete(ani_lst.get(option - 1));
            }else if(option == 0) {
                break;
            }else{
                System.err.println("»» Error 101 : Option Invalid! Please try again ««");
            }
        }while(!success);

    }
}
