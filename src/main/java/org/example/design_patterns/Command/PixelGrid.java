package org.example.design_patterns.Command;

public class PixelGrid {
    private final int SIZE = 8;
    private int[][] pixels = new int[SIZE][SIZE];
    private int cursorX = 0;
    private int cursorY = 0;

    public void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(SIZE - 1, cursorX + dx));
        cursorY = Math.max(0, Math.min(SIZE - 1, cursorY + dy));
    }

    public void togglePixel() {
        pixels[cursorY][cursorX] = (pixels[cursorY][cursorX] == 0) ? 1 : 0;
        System.out.println("Toggled pixel at " + cursorX + "," + cursorY + " to " + pixels[cursorY][cursorX]);
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("    {");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(pixels[i][j] + (j < SIZE - 1 ? ", " : ""));
            }
            System.out.println("}" + (i < SIZE - 1 ? "," : ""));
        }
        System.out.println("};");
    }

    // Getters for UI rendering
    public int getCursorX() { return cursorX; }
    public int getCursorY() { return cursorY; }
    public int[][] getPixels() { return pixels; }
}
