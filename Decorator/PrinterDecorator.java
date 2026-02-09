package Decorator;

public abstract class PrinterDecorator implements Printer{
    protected Printer decoratedPrinter;

    public PrinterDecorator(Printer printer) {
        this.decoratedPrinter = printer;
    }

    public void print(String message) {
        decoratedPrinter.print(message);
    }
}
