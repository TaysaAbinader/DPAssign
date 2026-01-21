class CityMap extends Map {

    CityMap(int size) {
        tiles = new Tile[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Random tile type (Road, Forest, Building).
                int i = (int)(Math.random() * 3);
                switch (i) {
                case 0: // ROAD
                    tiles[row][col] = createTile(Tile.Type.ROAD);
                    break;
                case 1: // FOREST
                    tiles[row][col] = createTile(Tile.Type.FOREST);
                    break;
                case 2: // BUILDING
                    tiles[row][col] = createTile(Tile.Type.BUILDING);
                    break;
                }
            }
        }
    }

    public Tile createTile(Tile.Type type) {
        switch (type) {
        case ROAD:
            return new RoadTile();
        case FOREST:
            return new ForestTile();
        case BUILDING:
            return new BuildingTile();
        default:
            throw new RuntimeException("Unknown tile type");
        }
    }

}
