package org.example.design_patterns.Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    // Constants for rendering
    private static final int TILE_SIZE = 40;
    private static final int MAP_SIZE = 10;

    //Existing logic to create the Map object
    public static Map createMap(Map.Type type, int size) {
        return type == Map.Type.CITY ? new CityMap(size) : new WildernessMap(size);
    }

    @Override
    public void start(Stage primaryStage) {
        // Generate the data structure using Factory Method pattern
        Map gameMap = Game.createMap(Map.Type.WILDERNESS, MAP_SIZE);

        Canvas canvas = new Canvas(MAP_SIZE * TILE_SIZE, MAP_SIZE * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Use Flyweight to draw the map
        renderMap(gc, gameMap);

        primaryStage.setTitle("RPG Map - Flyweight Rendering");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
    }

    private void renderMap(GraphicsContext gc, Map map) {
        for (int row = 0; row < MAP_SIZE; row++) {
            for (int col = 0; col < MAP_SIZE; col++) {
                Tile tile = map.tiles[row][col];

                // Only one instance of each image is stored in memory
                javafx.scene.image.Image texture = TileGraphicFactory.getGraphic(tile);

                // EXTRINSIC STATE: The position (row, col) stored in the individual tile
                // This tells us WHERE to draw the shared image
                double x = col * TILE_SIZE;
                double y = row * TILE_SIZE;

                gc.drawImage(texture, x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        // In JavaFX, we call launch() instead of running logic in main
        launch(args);
    }
}
