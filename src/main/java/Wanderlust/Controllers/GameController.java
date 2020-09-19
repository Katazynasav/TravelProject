package Wanderlust.Controllers;

import Wanderlust.CodeManipulation.Countries;
import Wanderlust.CodeManipulation.SceneManipulation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    SceneManipulation sceneManipulation = new SceneManipulation();
    String random;
    @FXML
    private Label randomCountry;

    @FXML
    private Text text;


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

    public void changeText() throws InterruptedException {
        text.setText("Click on country name to see what You can visit.Button 'i' will show you info about this country");
        setRandomCountry();

    }

    public void setRandomCountry() throws InterruptedException {
        Countries countries = new Countries();
        String country = countries.randomCountry();
        System.out.println(country);
        random = String.valueOf(country);
        randomCountry.setText(random);

    }

    public void wikipedia() {
        try {
            Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/" + random).toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void thingToDo() {
        try {
            Desktop.getDesktop().browse(new URL("https://www.tripadvisor.com/Search?q=" + random + "&searchSession").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}



