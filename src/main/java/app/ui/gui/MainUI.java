package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUI implements Initializable {

    @FXML
    public Button loginButton;
    public Button devButton;
    public Button registerButton;

    public DropShadow shadow;

    private App mainApp;

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
        this.shadow = buttonShadow();
    }

    public App getMainApp() {
        return this.mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void dev(ActionEvent action) {
        try {
            DevUI developersUI = (DevUI) this.mainApp.replaceSceneContent("/fxml/Dev.fxml");
            developersUI.setMainApp(this.mainApp);
            developersUI.setMainUI(this);
        } catch (Exception e) {
            AlertUI.infoAlert(e.getMessage(), "Error");
        }

    }

    public void login(ActionEvent action) {
        try {
            LoginUI loginUI = (LoginUI) this.mainApp.replaceSceneContent("/fxml/loginWindow.fxml");
            loginUI.setMainApp(this.mainApp);
        } catch (Exception e) {
            AlertUI.infoAlert(e.getMessage(), "Error");
        }
    }

    public void register(ActionEvent action) {
        try {

        }catch (Exception e) {

        }
    }

    public void loginMouseOver(MouseEvent action) {
        this.loginButton.setMinWidth(175);
        this.loginButton.setLayoutX(213);
        this.loginButton.setStyle("-fx-background-color: #F9AE20" + " ; -fx-background-radius: 30" + " ; -fx-background-position: center");
        this.loginButton.setAlignment(Pos.CENTER);
        this.loginButton.setCursor(Cursor.HAND);
        this.loginButton.setEffect(this.shadow);
    }

    public void registerMouseOver(MouseEvent action) {
        this.registerButton.setMinWidth(175);
        this.registerButton.setLayoutX(213);
        this.registerButton.setStyle("-fx-background-color:" + "#F9AE20" + " ; -fx-background-radius:" + 30);
        this.registerButton.setAlignment(Pos.CENTER);
        this.registerButton.setCursor(Cursor.HAND);
        this.registerButton.setEffect(this.shadow);
    }

    public void devMouseOver(MouseEvent action) {
        this.devButton.setMinWidth(175);
        this.devButton.setLayoutX(213);
        this.devButton.setStyle("-fx-background-color:" + "#F9AE20" + " ; -fx-background-radius:" + 30);
        this.devButton.setAlignment(Pos.CENTER);
        this.devButton.setCursor(Cursor.HAND);
        this.devButton.setEffect(this.shadow);
    }

    public void loginMouseExit(MouseEvent action) {
        this.loginButton.setMinWidth(137);
        this.loginButton.setStyle("-fx-background-color:" + "#FABE4C" + " ; -fx-background-radius:" + 30);
        this.loginButton.setAlignment(Pos.CENTER);
        this.loginButton.setLayoutX(233);
        this.loginButton.setEffect(null);
    }

    public void registerMouseExit(MouseEvent action) {
        this.registerButton.setMinWidth(137);
        this.registerButton.setStyle("-fx-background-color:" + "#FABE4C" + " ; -fx-background-radius:" + 30);
        this.registerButton.setAlignment(Pos.CENTER);
        this.registerButton.setLayoutX(233);
        this.registerButton.setEffect(null);
    }

    public void devMouseExit(MouseEvent action) {
        this.devButton.setMinWidth(137);
        this.devButton.setStyle("-fx-background-color:" + "#FABE4C" + " ; -fx-background-radius:" + 30);
        this.devButton.setAlignment(Pos.CENTER);
        this.devButton.setLayoutX(233);
        this.devButton.setEffect(null);
    }

    public DropShadow buttonShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.WHITE);
        shadow.setWidth(74.37);
        shadow.setHeight(56.58);
        shadow.setRadius(32.24);
        return shadow;
    }


}
