package Wanderlust.CodeManipulation;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManipulation {

    public void changeScene(ActionEvent event, String scene) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource(scene));
        Scene newScene = new Scene(fxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
