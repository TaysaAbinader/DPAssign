class WildernessMap extends Map {

    WildernessMap(int size) {
        tiles = new Tile[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Random tile type (Swamp, Forest, Water).
                int i = (int)(Math.random() * 3);
                switch (i) {
                case 0: // SWAMP
                    tiles[row][col] = createTile(Tile.Type.SWAMP);
                    break;
                case 1: // FOREST
                    tiles[row][col] = createTile(Tile.Type.FOREST);
                    break;
                case 2: // WATER
                    tiles[row][col] = createTile(Tile.Type.WATER);
                    break;
                }
            }
        }
    }

    public Tile createTile(Tile.Type type) {
        switch (type) {
        case SWAMP:
            return new SwampTile();
        case FOREST:
            return new ForestTile();
        case WATER:
            return new WaterTile();
        }
        throw new RuntimeException("Unknown tile type");
    }

}
