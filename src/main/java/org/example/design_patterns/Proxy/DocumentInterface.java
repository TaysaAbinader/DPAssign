package org.example.design_patterns.Proxy;


import java.util.Date;

public interface DocumentInterface {

    String getIdentifier();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;

}
