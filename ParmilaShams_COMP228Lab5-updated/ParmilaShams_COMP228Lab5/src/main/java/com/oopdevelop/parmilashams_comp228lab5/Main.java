package com.oopdevelop.parmilashams_comp228lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/oopdevelop/parmilashams_comp228lab5/hello-view.fxml"));

        PlayerController controller = loader.getController();
        VBox root = loader.load();

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Play Games");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}