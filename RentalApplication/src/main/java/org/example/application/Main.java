package org.example.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.application.view.LoginView;

public class Main extends Application {
    public static Stage mainStage;
    public static Stage secondStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = new Stage();
        secondStage = new Stage();
        Scene sc = new Scene(new LoginView(), 300, 300);
        mainStage.setTitle("SK-2");
        mainStage.setScene(sc);
        mainStage.show();
    }
}
