package com.stud.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("/images/icons8-calculator-64.png");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindowInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Calculator");

       ((MainWindowController)fxmlLoader.getController()).initialize(primaryStage);
        primaryStage.show();
    }

    public void run() {
        launch();
    }
}

//Calculator icon by https://icons8.com Icons8>