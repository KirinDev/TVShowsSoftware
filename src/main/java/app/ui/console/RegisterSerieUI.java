package app.ui.console;

import app.controller.RegisterAnimeController;
import app.controller.RegisterSerieController;
import app.controller.RegisterShowController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegisterSerieUI implements Runnable {

    private RegisterSerieController ctrl;
    private RegisterShowController sctrl;

    public RegisterSerieUI() {
        ctrl = new RegisterSerieController();
        sctrl = new RegisterShowController();
    }

    public void run() {

        String name; int aired; String genres; double duration;
        double score; int num_episodes;

        boolean success = false;
        do {
            System.out.println("\n| Anime Registration |");
            name = Utils.readLineFromConsole("Name: ");
            aired = Utils.readIntegerFromConsole("Aired: ");
            genres = Utils.readLineFromConsole("Genres: ");
            duration = Utils.readDoubleFromConsole("Duration: ");
            score = Utils.readDoubleFromConsole("Score: ");
            num_episodes = Utils.readIntegerFromConsole("Number of episodes: ");

            if(ctrl.create(name, aired, genres, duration, score, num_episodes)) {
                String confirm = dataConfirmation(name, aired, genres, duration, score, num_episodes);
                if(confirm.equals("yes")) {
                    if(ctrl.save()) {
                        sctrl.create(name, aired, genres, duration, score);
                        sctrl.save();
                        System.out.println( "\n>>The Serie was registered successfully! :)<<" );
                        success = true;
                    }
                }else{
                    System.out.println("\n>>Operation aborted<< X_X");
                }
            }else{
                System.err.println("»» Data introduced invalid! Please try again ««");
            }
        }while(!success);
    }

    public String dataConfirmation(String name, int aired, String genres, double duration, double score, int num_episodes) {
        List<String> options = new ArrayList<>();
        int option;

        System.out.println("\n| Serie Data Confirmation |");
        System.out.println("\nName: " + name);
        System.out.println("Aired: " + aired);
        System.out.println("Genres: " + genres);
        System.out.println("Duration: " + duration);
        System.out.println("Score: " + score);
        System.out.println("Number of episodes: " + num_episodes);

        options.add("yes");
        options.add("no");
        option = Utils.showAndSelectIndex(options, "\nSelect an option:");

        return options.get(option);
    }
}
