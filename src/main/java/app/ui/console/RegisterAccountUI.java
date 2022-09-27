package app.ui.console;

import app.controller.RegisterAccountController;
import app.ui.console.utils.Utils;

public class RegisterAccountUI implements Runnable{

    private RegisterAccountController ctrl;

    public RegisterAccountUI() {
        ctrl = new RegisterAccountController();
    }

    public void run() {

        String name; String email; String pwd;

        boolean success = false;
        do {
            System.out.println("\n| Account Registration |");
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
