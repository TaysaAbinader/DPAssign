package org.example.design_patterns.Proxy;

import java.util.*;

public class AccessControlService {

    private static AccessControlService instance;
    private Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        permissions.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.containsKey(documentId) && permissions.get(documentId).contains(username);
    }

}
