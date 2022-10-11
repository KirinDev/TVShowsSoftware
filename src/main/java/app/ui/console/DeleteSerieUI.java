package app.ui.console;

import app.controller.DeleteSerieController;
import app.domain.model.Serie;
import app.ui.console.utils.Utils;

import java.util.List;

public class DeleteSerieUI implements Runnable {

    private DeleteSerieController ctrl;

    public DeleteSerieUI() {
        ctrl = new DeleteSerieController();
    }

    public void run() {
        boolean success = false;
        int option = 0;
        do {
            List<Serie> ser_lst = ctrl.listAllSerie();
            int counter = 1;
            System.out.println("\n| Choose the serie you wish to delete |");

            for(Serie i : ser_lst) {
                System.out.println(counter + ". " + i.getName());
            }

            System.out.println("\n0 - Cancel");
            option = Utils.readIntegerFromConsole("Type your option: ");

            if(option > 0 && option <= ser_lst.size()) {
                ctrl.delete(ser_lst.get(option - 1));
                success = true;
            }else if(option == 0) {
                break;
            }else{
                System.err.println("»» Error 101 : Option Invalid! Please try again ««");
            }
        }while(!success);
    }
}
