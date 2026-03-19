package org.example.design_patterns.Proxy;

import java.util.*;

public class Library {
    private Map<String, DocumentInterface> documents = new HashMap<>();

    public void addProtectedDocument(String id, String content) {
        Document realDocument = new Document(id, content);
        documents.put(id, new DocumentProxy(realDocument));
    }

    public void addDocument(String id, String content) {
        documents.put(id, new Document(id, content));
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
