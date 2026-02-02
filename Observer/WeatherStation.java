package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WeatherStation implements Subject, Runnable {
    private List<WeatherObserver> observers;
    private int temperature;
    private Random random;

    private final int Max = 30;
    private final int Min = -20;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
        // Set initial random temperature between MIN and MAX
        temperature = random.nextInt((Max - Min) + 1) + Min;
        System.out.println("Weather Station initialized at " + temperature + " degrees.");
    }

    @Override
    public synchronized void registerSubject(WeatherObserver observer) {
        observers.add(observer);
        // Added .toString() or name handling could be done here,
        // strictly using your print statement:
        System.out.println(observer + " Added to the system.");
    }

    @Override
    public synchronized void removeSubject(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println(observer + " Removed from the system.");
    }

    @Override
    public synchronized void notifySubjects() {
        // FIX: Removed the empty "{}" that was here previously
        for (WeatherObserver observer : new ArrayList<>(observers)) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Your specified sleep time
                Thread.sleep(8000);

                boolean increase = random.nextBoolean();
                if (increase) {
                    temperature = Math.min(temperature + 2, Max);
                } else {
                    temperature = Math.max(temperature - 2, Min);
                }

                System.out.println("\nTemperature updated to " + temperature + "°C");

                // Notify all registered observers
                notifySubjects();

            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
