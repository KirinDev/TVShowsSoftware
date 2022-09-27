package app.ui.console;

import app.controller.RegisterAnimeController;
import app.controller.RegisterShowController;
import app.domain.model.Anime;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegisterAnimeUI implements Runnable {

    private RegisterAnimeController ctrl;
    private RegisterShowController sctrl;

    public RegisterAnimeUI() {
        ctrl = new RegisterAnimeController();
        sctrl = new RegisterShowController();
    }

    public void run() {
        String name; int aired; String genres; double duration;
        double score; int num_episodes; String studio; String type;

        boolean success = false;
        do {
            System.out.println("\n| Anime Registration |");
            name = Utils.readLineFromConsole("Name: ");
            aired = Utils.readIntegerFromConsole("Aired: ");
            genres = Utils.readLineFromConsole("Genres: ");
            studio = Utils.readLineFromConsole("Studio: ");
            type = Utils.readLineFromConsole("Type: ");
            duration = Utils.readDoubleFromConsole("Duration: ");
            score = Utils.readDoubleFromConsole("Score: ");
            num_episodes = Utils.readIntegerFromConsole("Number of episodes: ");

            if(ctrl.create(name, aired, genres, duration, score, num_episodes, studio, type)) {
                String confirm = dataConfirmation(name, aired, genres, duration, score, num_episodes, studio, type);
                if(confirm.equals("yes")) {
                    if(ctrl.save()) {
                        sctrl.create(name, aired, genres, duration, score);
                        sctrl.save();
                        System.out.println( "\n>>The Anime was registered successfully! :)<<" );
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

    public String dataConfirmation(String name, int aired, String genres, Double duration, Double score, int num_episodes, String studio, String type) {
        List<String> options = new ArrayList<>();
        int option;

        System.out.println("\n| Anime Data Confirmation |");
        System.out.println("\nName: " + name);
        System.out.println("Aired: " + aired);
        System.out.println("Genres: " + genres);
        System.out.println("Studio: " + studio);
        System.out.println("Type: " + type);
        System.out.println("Duration: " + duration);
        System.out.println("Score: " + score);
        System.out.println("Number of episodes: " + num_episodes);

        options.add("yes");
        options.add("no");
        option = Utils.showAndSelectIndex(options, "\nSelect an option:");

        return options.get(option);
    }
}
