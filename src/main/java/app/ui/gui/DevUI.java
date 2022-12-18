package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DevUI implements Initializable {

    @FXML
    public Button returnButton;

    private App mainApp;
    private MainUI mainUI;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void setMainUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }

    @FXML
    public void returnButton(ActionEvent actionEvent) {
        this.mainUI.getMainApp().toMainScene();
    }
}
