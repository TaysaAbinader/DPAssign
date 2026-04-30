package org.example.design_patterns.Command;

public class MoveCursorRightCommand implements Command {
    private PixelGrid grid;
    public MoveCursorRightCommand(PixelGrid grid) { this.grid = grid; }
    @Override public void execute() { grid.moveCursor(1, 0); }
}
