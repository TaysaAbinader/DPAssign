package org.example.design_patterns.Flyweight;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

public class TileGraphicFactory {

    private static final Map<Tile.Type, Image> images = new HashMap<>();

    public static Image getGraphic(Tile tile) {
        Tile.Type type = tile.getType();
        if (!images.containsKey(type)) {
            // In a real project, you'd use real image files here
            // For now, we'll use placeholder images from a URL to keep it simple
            String url = String.format("https://placehold.jp/32/%s/ffffff/32x32.png?text=%s",
                                       tile.getBackgroundColor(), tile.getCharacter());
            images.put(type, new Image(url));
            System.out.println("Shared Flyweight created for: " + type);
        }
        return images.get(type);
    }
}
