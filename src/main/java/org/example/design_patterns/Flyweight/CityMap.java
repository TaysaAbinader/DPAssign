package org.example.design_patterns.Flyweight;

class CityMap extends Map {

    CityMap(int size) {
        tiles = new Tile[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int i = (int)(Math.random() * 3);
                switch (i) {
                    case 0:
                        tiles[row][col] = createTile(Tile.Type.ROAD, row, col);
                        break;
                    case 1:
                        tiles[row][col] = createTile(Tile.Type.FOREST, row, col);
                        break;
                    case 2:
                        tiles[row][col] = createTile(Tile.Type.BUILDING, row, col);
                        break;
                }
            }
        }
    }

    @Override
    public Tile createTile(Tile.Type type, int row, int col) {
        switch (type) {
            case ROAD:     return new RoadTile(row, col);
            case FOREST:   return new ForestTile(row, col);
            case BUILDING: return new BuildingTile(row, col);
            default: throw new RuntimeException("Unknown tile type");
        }
    }

}
