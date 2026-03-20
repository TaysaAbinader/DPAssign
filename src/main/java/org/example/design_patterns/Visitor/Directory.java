package org.example.design_patterns.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{
    private String name;
    private List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name; }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}
