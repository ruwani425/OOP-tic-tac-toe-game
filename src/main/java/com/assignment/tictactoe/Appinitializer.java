package com.assignment.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Appinitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Appinitializer.class.getResource("/view/welcome-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tic-Tac-Toe Game");
        stage.setResizable(false);  // Disable resizing
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
