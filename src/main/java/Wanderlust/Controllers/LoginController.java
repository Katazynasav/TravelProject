package Wanderlust.Controllers;


import Wanderlust.Database.DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private Label loginMessage;

    @FXML
    private PasswordField userLoginPasswordField;

    @FXML
    private TextField userLoginEmailField;

    @FXML
    private void singUpScene(ActionEvent event) throws IOException {
        Parent singUpFxml = FXMLLoader.load(getClass().getResource("/fxml/singUp.fxml"));
        Scene singUpScene = new Scene(singUpFxml);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(singUpScene);
        window.show();
    }
    public void loginValidation(ActionEvent event) {
        UserDAO userDAO = new UserDAO();
        String password = userDAO.getUser(userLoginEmailField.getText());
        password = password.substring(1, password.length() - 1);

        if(userLoginPasswordField.getText().isBlank() || userLoginPasswordField.getText().isBlank())  {
            loginMessage.setText("Email or password field is empty.");
        } else if (userLoginPasswordField.getText().equals(password)) {
            loginMessage.setText("Connected.");
        }else{
            loginMessage.setText("Email or password is incorrect.");
        }
    }

    public void exitTheProgramOnAction (ActionEvent event){
        System.exit(0);
    }
}









