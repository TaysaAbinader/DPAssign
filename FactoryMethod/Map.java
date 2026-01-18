abstract class Map {

    public enum Type { CITY, WILDERNESS };
    public Tile[][] tiles;

    public abstract Tile createTile(Tile.Type type);

    void display() {
        if (tiles == null) return;

        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                // 3. Each tile knows how to print itself
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
   };
}
