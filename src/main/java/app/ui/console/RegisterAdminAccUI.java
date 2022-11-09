package app.ui.console;

import app.controller.RegisterAdminAccController;
import app.ui.console.utils.Utils;

public class RegisterAdminAccUI implements Runnable {

    private RegisterAdminAccController ctrl;

    public RegisterAdminAccUI() {
        ctrl = new RegisterAdminAccController();
    }

    public void run() {

        String name; String email; String pwd;

        boolean success = false;
        do {
            System.out.println("\n| Admin Account Registration |");
            name = Utils.readLineFromConsole("Name: ");
            email = Utils.readLineFromConsole("Email: ");
            pwd = Utils.readLineFromConsole("Password: ");

            try {
                if(ctrl.register(name, email, pwd)) {
                    System.out.println("> The account was registered successfully < !");
                    success = true;
                }

            }catch (Exception e) {
                System.err.println("»» Error: Email or Password invalid! Please try again ««");
            }
        }while(!success);

    }
}
