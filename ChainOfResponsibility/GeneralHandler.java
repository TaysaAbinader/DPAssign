package ChainOfResponsibility;

public class GeneralHandler extends Handler {
    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.GENERAL) {
            return "[PR] Feedback from " + message.getSenderEmail() + " analyzed. Sending thank you.";
        }
        return passToNext(message);
    }
}
