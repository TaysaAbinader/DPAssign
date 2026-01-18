class WildernessMap implements Map {

    WildernessMap() {
        // TODO: Populate tiles with random wilderness tiles.
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
