abstract class Map {

    public enum Type { CITY, WILDERNESS };
    public Tile[][] tiles = {};

    public abstract Tile createTile(Tile.Type type);

    void display() {
        // TODO: Iterate over tiles (matrix) and print.

   };
}
