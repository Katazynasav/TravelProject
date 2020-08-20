package Wanderlust.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Wanderlust.Database.DAO.UserDAO;
import Wanderlust.Database.Domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



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
        private Label message;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
        }

        public void saveToDatabase() {
            if (newUserPassword.getText().matches(newUserConfirmPassword.getText())) {
                UserDAO userDAO = new UserDAO();
                User user = new User(newUserName.getText(),newUserSurname.getText(),newUserEmail.getText(),newUserPassword.getText());
                userDAO.createUser(user);
                message.setText("Welcome to Wanderlust!");
            } else {
                message.setText("Password doesn't match.");
            }
        }

        public void exitTheProgramOnAction (ActionEvent event){
            System.exit(0);
        }

    }




