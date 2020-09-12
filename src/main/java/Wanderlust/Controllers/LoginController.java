package Wanderlust.Controllers;


import Wanderlust.DAO.UserDAO;
import Wanderlust.CodeManipulation.SceneManipulation;
import Wanderlust.Domain.User;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    public TextField userLoginEmailField;
    SceneManipulation sceneManipulation = new SceneManipulation();
    UserDAO userDAO = new UserDAO();
    @FXML
    private Label loginMessage;
    @FXML
    private Button singUpButton;
    @FXML
    private AnchorPane parentContainer;
    @FXML
    private PasswordField userLoginPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void singUpScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/registration.fxml"));
        Scene scene = singUpButton.getScene();

        root.translateXProperty().set(scene.getWidth());
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void overviewScene(ActionEvent event) throws IOException {
        sceneManipulation.changeScene(event, "/fxml/overview.fxml");
    }

    public void loginValidation(ActionEvent event) throws IOException {
        loginVerificationIfNull();
        userSession(event);
    }

    public void loginVerificationIfNull() {
        String email = userDAO.identifyUser(userLoginEmailField.getText());
        email = email.substring(1, email.length() - 1);

        if (userLoginPasswordField.getText().isBlank() || userLoginPasswordField.getText().isBlank()) {
            loginMessage.setText("Email or password field is empty.");
        } else if (!userLoginEmailField.getText().equals(email)) {
            loginMessage.setText("Please create an account.");
        }

    }


    public void userSession(ActionEvent event) throws IOException {
        User user = userDAO.getUser(userLoginEmailField.getText());
        if (userLoginPasswordField.getText().equals(user.getUserPassword())) {
            overviewScene(event);
        } else {
            loginMessage.setText("Your password is incorrect.");
        }
    }


    public void exitTheProgramOnAction(ActionEvent event) {
        System.exit(0);
    }
}










