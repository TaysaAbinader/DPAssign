package Decorator;

public class Main {
    public static void main(String[] args) {
        String testMessage = "Hello World!";

        System.out.println(">> Basic Printer <<");
        Printer printer = new BasicPrinter();
        printer.print(testMessage);

        System.out.println();

        System.out.println(">> Printer 2 <<");
        Printer printer2 = new EncryptedPrinter(new XmlPrinter(new BasicPrinter()));
        printer2.print(testMessage);

        System.out.println();

        System.out.println(">> Printer 3 <<");
        Printer printer3 = new XmlPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer3.print(testMessage);
    }
}
