package com.example.democounterjavafx.controller;

import com.example.democounterjavafx.model.CounterModel;
import com.example.democounterjavafx.view.CounterView;
import javafx.stage.Stage;

public class CounterController {
    private final CounterModel model;
    private final CounterView view;

    public CounterController(CounterModel model, CounterView view) {
        this.model = model;
        this.view = view;

        // Bind button actions
        view.getIncrementButton().setOnAction(_ -> {
            model.increment();
            updateView();
        });

        view.getDecrementButton().setOnAction(_ -> {
            model.decrement();
            updateView();
        });
    }

    private void updateView() {
        view.setCount(model.getCount());
    }

    public void start(Stage stage) {
        updateView();
        view.show(stage);

        // Add shutdown hook to close socket
        stage.setOnCloseRequest(_ -> model.close());
    }
}