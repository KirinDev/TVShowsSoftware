package app.controller;

import app.auth.AuthFacade;
import app.auth.UserSession;
import app.domain.model.Company;
import app.domain.shared.Constants;
import app.properties.PropertiesCache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class App {

    private Company company;
    private AuthFacade authFacade;

    private App() {

        try {
            PropertiesCache props = new PropertiesCache();
            this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
            this.authFacade = this.company.getAuthFacade();

        }catch(Exception e){
            e.printStackTrace();
        }
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }

    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private void bootstrap() {

        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_USER,Constants.ROLE_USER);
        this.authFacade.addUserWithRole("Main Administrator", "admin@shows.pt", "1811",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Software User", "weeb@shows.pt", "mommy milkers",Constants.ROLE_ADMIN);
    }

    private static App singleton = null;
    public static App getInstance() {
        if(singleton == null) {
            synchronized(App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }
}
