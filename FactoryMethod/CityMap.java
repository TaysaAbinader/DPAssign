class CityMap implements Map {

    CityMap() {
        // TODO: Populate tiles with random city tiles.
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
