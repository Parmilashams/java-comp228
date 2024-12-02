package com.oopdevelop.parmilashams_comp228lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        VBox root = FXMLLoader.load(getClass().getResource("player_view.fxml"));

        // Create the scene and add the root layout
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Player and Game Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
