package Wanderlust.Controllers;

import Wanderlust.CodeManipulation.SceneManipulation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController extends LoginController implements Initializable {
    SceneManipulation sceneManipulation = new SceneManipulation();

    @FXML
    private Text userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void overviewScene(ActionEvent event) throws IOException {
        sceneManipulation.changeScene(event, "/fxml/overview.fxml");
    }
    public void addCountries(ActionEvent event) throws IOException {
        sceneManipulation.changeScene(event, "/fxml/addCountries.fxml");
    }
    public void gameScene(ActionEvent event) throws IOException {
        sceneManipulation.changeScene(event, "/fxml/game.fxml");
    }
    public void settingsScene(ActionEvent event) throws IOException {
        sceneManipulation.changeScene(event, "/fxml/Settings.fxml");
    }
    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}

