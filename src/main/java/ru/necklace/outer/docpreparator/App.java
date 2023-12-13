package ru.necklace.outer.docpreparator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class App extends Application {
    public static void main(String[] args) {
        App.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        initPrimary(primaryStage);
        primaryStage.show();
    }

    private void initPrimary(Stage primaryStage) throws IOException {
        try (InputStream iconStream = getClass().getResourceAsStream("/icons/MainTitle.png")) {
            Image headerImage = new Image(iconStream);
            primaryStage.getIcons().add(headerImage);
        }

        primaryStage.setTitle("Заполнятель допусков");

        Label label = new Label("Hello World");
        label.setAlignment(Pos.CENTER);
        Scene primary = new Scene(label);
        primaryStage.setScene(primary);

    }
}
