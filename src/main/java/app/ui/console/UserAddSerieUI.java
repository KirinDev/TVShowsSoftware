package app.ui.console;

import app.controller.AddSerieController;
import app.domain.model.Serie;
import app.ui.console.utils.Utils;

public class UserAddSerieUI implements Runnable {

    private AddSerieController ctrl;

    public UserAddSerieUI() {
        ctrl = new AddSerieController();
    }

    public void run() {
        boolean success = false;

        do {
            String name = Utils.readLineFromConsole("\nInsert name of the serie: ");
            System.out.println("\n0 - Cancel");

            Serie serie = ctrl.getByName(name);

            if(name.equals("0"))
                break;

            if( serie != null) {
                if(ctrl.addSerie(serie)) {
                    System.out.println("*The serie '" + name + "' was added successfully to your list*");
                    success = true;
                }else{
                    System.err.println("»» Error 404: The serie '" + name + "' already exist in your list ««");
                }
            }else{
                System.err.println("»» Error 404: The serie '" + name + "' was not found! ««");
            }
        }while(!success);
    }
}
