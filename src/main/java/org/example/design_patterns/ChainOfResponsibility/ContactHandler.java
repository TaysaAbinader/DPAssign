package org.example.design_patterns.ChainOfResponsibility;

public class ContactHandler extends Handler {
    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            return "[Support] Forwarding " + message.getSenderEmail() + " to the Customer Success team.";
        }
        return passToNext(message);
    }
}
