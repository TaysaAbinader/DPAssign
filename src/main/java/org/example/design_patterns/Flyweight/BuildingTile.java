package org.example.design_patterns.Flyweight;

public class BuildingTile extends Tile {

    public BuildingTile(int row, int column) {
        super(Tile.Type.BUILDING, row, column);
    }

}
