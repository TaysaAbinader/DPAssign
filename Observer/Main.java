package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        ClientObserver station1 = new ClientObserver("Bedroom");
        ClientObserver station2 = new ClientObserver("Office");

        station.registerSubject(station1);
        station.registerSubject(station2);

        Thread thread = new Thread(station);
        thread.start();

        try {
            Thread.sleep(16000);

            System.out.println("\nRemoving 'Bedroom'");
            station.removeSubject(station1);

            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop system (force exit for this example)
        System.exit(0);
    }
}
