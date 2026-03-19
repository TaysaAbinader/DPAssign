package org.example.design_patterns.Proxy;

import java.util.Date;

public class Document implements DocumentInterface {
    private String identifier;
    private Date creationDate;
    private String content;

    public Document (String identifier, String content) {
        this.identifier = identifier;
        this.creationDate = new Date();
        this.content = content;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException{
        return this.content;
    }

}
