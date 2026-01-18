public abstract class Tile {

    public enum Type { SWAMP, WATER, ROAD, FOREST, BUILDING};

    private Type type_;

    Tile(Type type) {
        type_ = type;
    };

    public char getCharacter() {
        switch (type_) {
        case SWAMP:
            return 'S';
        case WATER:
            return 'W';
        case ROAD:
            return 'R';
        case FOREST:
            return 'F';
        case BUILDING:
            return 'B';
        }
        return ' ';
    };

    public String getType() {
        return type_.name();
    };

}
