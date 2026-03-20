package org.example.design_patterns.Visitor;

public class FileSystemMain {
    public static void main(String[] args) {
        // Setup Structure
        Directory root = new Directory("Root");
        Directory music = new Directory("Music");

        root.addElement(new File("resume.pdf", 2));
        root.addElement(music);

        music.addElement(new File("song1.mp3", 5));
        music.addElement(new File("song2.mp3", 7));
        music.addElement(new File("notes.txt", 1));

        // 1. Calculate Size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + "MB");

        // 2. Search for .mp3 files
        SearchVisitor searchVisitor = new SearchVisitor(".mp3");
        root.accept(searchVisitor);
        System.out.println("Found " + searchVisitor.getFoundFiles().size() + " .mp3 files.");
    }
}
