package Wanderlust.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Wanderlust.CodeManipulation.SceneManipulation;
import Wanderlust.DAO.UserDAO;
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


public class SingUpController implements Initializable {
    @FXML
    private TextField newUserName;
    @FXML
    private TextField newUserSurname;
    @FXML
    private TextField newUserEmail;
    @FXML
    private PasswordField newUserPassword;
    @FXML
    private PasswordField newUserConfirmPassword;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane singUp;
    @FXML
    private Label errorMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene scene = loginButton.getScene();

        root.translateXProperty().set(scene.getWidth());
        singUp.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(800), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void saveToDatabase(ActionEvent event) throws IOException {
        if (newUserPassword.getText().matches(newUserConfirmPassword.getText())) {
            UserDAO userDAO = new UserDAO();
            User user = new User(newUserName.getText(), newUserSurname.getText(), newUserEmail.getText(), newUserPassword.getText());
            userDAO.createUser(user);
            overviewScene(event);
        } else {
            errorMessage.setText("Password doesn't match.");
        }
    }

    public void overviewScene(ActionEvent event) throws IOException {
        SceneManipulation sceneManipulation = new SceneManipulation();
        sceneManipulation.changeScene(event, "/fxml/overview.fxml");
    }

    // private boolean isValidEmailAddress(String email) {
    // String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    // java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
    // java.util.regex.Matcher m = p.matcher(email);
    // return m.matches();
    // }
    //TODO


    public void exitTheProgram(ActionEvent event) {
        System.exit(0);
    }

}




