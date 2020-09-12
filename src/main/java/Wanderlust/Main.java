package Wanderlust;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(loginRoot, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
    launch(args);

    }
}
