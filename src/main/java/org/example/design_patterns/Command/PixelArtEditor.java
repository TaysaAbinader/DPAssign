package org.example.design_patterns.Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private PixelGrid grid = new PixelGrid();
    private Canvas canvas = new Canvas(400, 400);
    private final int CELL_SIZE = 50;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Button btnGenerate = new Button("Create Code");

        // Prevent the button from stealing keyboard focus
        btnGenerate.setFocusTraversable(false);

        // Command pattern used for the button
        btnGenerate.setOnAction(e -> new GenerateCodeCommand(grid).execute());

        root.getChildren().addAll(canvas, btnGenerate);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            Command cmd = null;
            switch (event.getCode()) {
                case UP ->    cmd = new MoveCursorUpCommand(grid);
                case DOWN ->  cmd = new MoveCursorDownCommand(grid);
                case LEFT ->  cmd = new MoveCursorLeftCommand(grid);
                case RIGHT -> cmd = new MoveCursorRightCommand(grid);
                case SPACE -> cmd = new TogglePixelCommand(grid);
            }
            if (cmd != null) {
                cmd.execute();
                draw(); // Redraw after command execution
            }
        });

        draw(); // Initial draw
        stage.setTitle("8-Bit Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int[][] pixels = grid.getPixels();

        // Clear and draw grid
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (pixels[y][x] == 1) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(1);
                gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw Cursor (Red Outline)
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        gc.strokeRect(grid.getCursorX() * CELL_SIZE, grid.getCursorY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    public static void main(String[] args) { launch(args); }
}
