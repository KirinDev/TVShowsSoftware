package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserUI implements Runnable {

    public UserUI() { }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Add show to my list " , new UserAddShowUI()));

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
