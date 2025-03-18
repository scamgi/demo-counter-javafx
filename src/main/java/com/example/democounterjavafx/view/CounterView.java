package com.example.democounterjavafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CounterView {
    private Label countLabel;
    private Button incrementButton;
    private Button decrementButton;
    private VBox root;

    public CounterView(Stage primaryStage) {
        // Initialize UI components
        countLabel = new Label("0");
        incrementButton = new Button("Increment");
        decrementButton = new Button("Decrement");

        // Setup layout
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(countLabel, incrementButton, decrementButton);

        // Setup scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Counter App");
        primaryStage.setScene(scene);
    }

    public void setCount(int count) {
        countLabel.setText(String.valueOf(count));
    }

    public Button getIncrementButton() {
        return incrementButton;
    }

    public Button getDecrementButton() {
        return decrementButton;
    }

    public void show(Stage stage) {
        stage.show();
    }
}