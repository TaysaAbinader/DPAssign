package org.example.design_patterns.Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.collections.FXCollections;

public class Gui extends Application {
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<IMemento> historyListView;
    private Stage historyStage;

    public void start(Stage stage) {
        controller = new Controller(this);
        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        HBox hBox = new HBox(10, colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setPadding(insets);

        Button btnHistory = new Button("View History");
        btnHistory.setOnAction(e -> openHistoryWindow());

        VBox vBox = new VBox(hBox, checkBox, new Label("Ctrl-Z: Undo | Ctrl-Y: Redo"), btnHistory);
        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown()) {
                if (event.getCode() == KeyCode.Z) controller.undo();
                if (event.getCode() == KeyCode.Y) controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    private void openHistoryWindow() {
        if (historyStage != null && historyStage.isShowing()) {
            historyStage.toFront();
            return;
        }

        historyStage = new Stage();
        historyListView = new ListView<>();
        refreshHistoryWindow();
        historyListView.setOnMouseClicked(event -> {
            IMemento selected = historyListView.getSelectionModel().getSelectedItem();
            if (selected != null) controller.restoreFromHistory(selected);
        });

        historyStage.setScene(new Scene(new VBox(new Label("Click a state to restore:"), historyListView), 250, 350));
        historyStage.setTitle("History");
        historyStage.show();
    }

    public void refreshHistoryWindow() {
        if (historyListView != null) {
            historyListView.setItems(FXCollections.observableArrayList(controller.getHistory()));
        }
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}
