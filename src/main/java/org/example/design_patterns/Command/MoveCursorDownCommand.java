package org.example.design_patterns.Command;

public class MoveCursorDownCommand implements Command {
    private PixelGrid grid;
    public MoveCursorDownCommand(PixelGrid grid) { this.grid = grid; }
    @Override public void execute() { grid.moveCursor(0, 1); }
}
