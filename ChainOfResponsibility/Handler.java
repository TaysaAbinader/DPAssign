package ChainOfResponsibility;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract String handle(Message message);

    protected String passToNext(Message message) {
        if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "End of chain: No specific handler found for this message.";
    }
}
