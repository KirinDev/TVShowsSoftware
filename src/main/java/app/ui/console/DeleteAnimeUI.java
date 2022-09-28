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
            System.out.println("| Choose the anime you wish to delete |");
            for(Anime i : ani_lst) {
                System.out.println(counter + ". " + i.getName());
            }
            option = Utils.readIntegerFromConsole("\nOption: ");
            if(option > 0 && option <= ani_lst.size()) {
                ctrl.delete(ani_lst.get(option - 1));
            }
        }while(!success);

    }
}
