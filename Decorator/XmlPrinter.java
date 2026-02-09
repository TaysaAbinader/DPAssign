package Decorator;

public class XmlPrinter extends PrinterDecorator {

    public XmlPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String xmlMessage = "<message>" + message + "</message>";
        super.print(xmlMessage);
    }
}
