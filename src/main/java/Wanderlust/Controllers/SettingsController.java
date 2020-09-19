package Wanderlust.Controllers;

import Wanderlust.CodeManipulation.SceneManipulation;
import Wanderlust.DAO.UserDAO;
import Wanderlust.Domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    SceneManipulation sceneManipulation = new SceneManipulation();
    UserDAO userDAO = new UserDAO();
    @FXML
    private Pane settingsMain;

    @FXML
    private Pane settingsChangePassword;

    @FXML
    private TextField Email;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField confirmNewPassword;

    @FXML
    private Pane settingsDelete;

    @FXML
    private TextField userEmail;

    @FXML
    private Text errorPassword;

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

    public void changeToPasswordPane() {
        settingsMain.setVisible(false);
        settingsChangePassword.setVisible(true);
        settingsDelete.setVisible(false);
    }

    public void updatePassword() {
        changeToPasswordPane();
        User user = userDAO.getUser(Email.getText());
        if (newPassword.getText().equals(confirmNewPassword.getText())) {
            user.setUserPassword(newPassword.getText());
            userDAO.updateUser(user);
        } else {
            errorPassword.setText("New password field and confirm password field must be the same.");
        }
    }

    public void changeToDeleteUserPane() {
        settingsMain.setVisible(false);
        settingsChangePassword.setVisible(false);
        settingsDelete.setVisible(true);
    }

    public void deleteUser(ActionEvent event) {
        changeToDeleteUserPane();
        User user = userDAO.getUser(userEmail.getText());
        userDAO.deleteUser(user);
        closeProgram(event);

    }


}

