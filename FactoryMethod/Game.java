public class Game {

    public static Map createMap(Map.Type type) {
        return type == Map.Type.CITY ? new CityMap() : new WildernessMap();
    };

    public static void main () {
        Map map = Game.createMap(Map.Type.WILDERNESS);

        map.display();

    }
}
