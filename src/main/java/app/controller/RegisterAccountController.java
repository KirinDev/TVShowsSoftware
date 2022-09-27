package app.controller;

import app.auth.AuthFacade;
import app.domain.shared.Constants;

public class RegisterAccountController {

    private App app;

    public RegisterAccountController() {
        this.app = App.getInstance();
    }

    public boolean register(String name, String email, String pwd) {
        AuthFacade auth = app.getCompany().getAuthFacade();
        return auth.addUserWithRole(name, email, pwd, Constants.ROLE_USER);
    }
}
