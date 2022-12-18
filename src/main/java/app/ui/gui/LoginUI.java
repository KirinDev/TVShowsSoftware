package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.mappers.dto.UserRoleDTO;
import app.ui.gui.rolesGUI.AdminWindowUI;
import app.ui.gui.rolesGUI.UserWindowUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginUI implements Initializable {

    private App mainApp;
    private AuthController authController;
    private Stage stage;
    private UserRoleDTO role;
    @FXML
    private Button btnDoLogin;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authController = new AuthController();
    }

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public App getMainApp() {
        return this.mainApp;
    }

    private void doLogin(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean success;
        if (!email.isBlank() && !password.isBlank()) {
            success = authController.doLogin(email, password);

            if (!success) {
                AlertUI.infoAlert("Invalid UserId and/or Password.", "Login Error");
            }else {
                List<UserRoleDTO> roles = this.authController.getUserRoles();
                if ((roles == null) || (roles.isEmpty())) {
                    AlertUI.infoAlert("Login Error", "User has no valid roles.");
                } else {
                    this.role = roles.get(0);
                }
            }
        } else {
            AlertUI.infoAlert("Email/Password fields can't be empty", "Login Error");
        }
    }

    public void getUiForRole() {
        switch (this.role.getDescription()) {
            case Constants.ROLE_ADMIN:

                try {
                    AdminWindowUI adminUI = (AdminWindowUI) this.mainApp.replaceSceneContent("/fxml/RolesFXML/AdminWindow.fxml");
                    adminUI.setLoginUI(this);
                    adminUI.setMainApp(this.mainApp);
                } catch (Exception e) {
                    AlertUI.infoAlert(e.getMessage(), "Error");
                }

                break;
            case Constants.ROLE_USER:
                try {
                    UserWindowUI userUI = (UserWindowUI) this.mainApp.replaceSceneContent("/fxml/RolesFXML/UserWindow.fxml");
                    userUI.setLoginUI(this);
                    userUI.setMainApp(this.mainApp);
                } catch (Exception e) {
                    AlertUI.infoAlert(e.getMessage(), "Error");
                }
                break;
            default:
                AlertUI.infoAlert("Only the NurseUI and CoordinatorUI are available for GUI", "Login Error");
        }
    }

    @FXML
    private void doLoginButton(ActionEvent actionEvent) {
        doLogin(actionEvent);
        getUiForRole();
    }
}
