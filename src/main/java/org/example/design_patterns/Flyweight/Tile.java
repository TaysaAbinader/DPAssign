package org.example.design_patterns.Flyweight;

public abstract class Tile {

    public enum Type { SWAMP, WATER, ROAD, FOREST, BUILDING};

    private Type type_;

    private int row;
    private int column;

    Tile(Type type, int row, int column) {
        this.type_ = type;
        this.row = row;
        this.column = column;
    };

    public Type getType() {
        return type_;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }

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

    public String getBackgroundColor() {
        switch (type_) {
            case SWAMP:
                return "8a750f";
            case WATER:
                return "24e1f9";
            case ROAD:
                return "df06ef";
            case FOREST:
                return "1fc75f";
            case BUILDING:
                return "c1bec5";
        }
        return "ffffff";
    };

}
