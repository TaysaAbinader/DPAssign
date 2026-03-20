package org.example.design_patterns.Visitor;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
