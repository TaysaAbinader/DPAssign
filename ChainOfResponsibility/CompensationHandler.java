package ChainOfResponsibility;

public class CompensationHandler extends Handler {
    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            return "[Finance] Reviewing claim for " + message.getSenderEmail() + ": " + message.getContent();
        }
        return passToNext(message);
    }
}
