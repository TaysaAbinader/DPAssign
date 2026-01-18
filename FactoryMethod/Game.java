public class Game {

    public static Map createMap(Map.Type type, int size) {
        return type == Map.Type.CITY ? new CityMap(size) : new WildernessMap(size);
    };

    public static void main () {
        Map map = Game.createMap(Map.Type.WILDERNESS, 8);

        map.display();

    }
}
