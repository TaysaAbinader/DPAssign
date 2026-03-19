package org.example.design_patterns.Proxy;

import java.util.Date;

public class DocumentProxy implements DocumentInterface {
    private Document realDocument;

    public DocumentProxy(Document document) {
        this.realDocument = document;
    }

    @Override
    public String getIdentifier() {
        return realDocument.getIdentifier();
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService service = AccessControlService.getInstance();

        if(service.isAllowed(realDocument.getIdentifier(), user.getUserName())) {
            return realDocument.getContent(user);
        }

        throw new AccessDeniedException("Access denied for user: " + user.getUserName());
    }
}
