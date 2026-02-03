package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_logger.txt");

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        logger.setFileName("newest_logger.txt");

        logger.write("Second Simulation started");
        logger.write("Processing new data...");
        logger.write("Second Simulation finished");
    }
}
