package org.example.design_patterns.Visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
