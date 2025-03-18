package com.example.democounterjavafx;

import com.example.democounterjavafx.controller.CounterController;
import com.example.democounterjavafx.model.CounterModel;
import com.example.democounterjavafx.view.CounterView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        CounterModel model = new CounterModel();
        CounterView view = new CounterView(primaryStage);
        CounterController controller = new CounterController(model, view);

        controller.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}