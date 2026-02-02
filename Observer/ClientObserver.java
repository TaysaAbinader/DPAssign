package Observer;

public class ClientObserver implements WeatherObserver{
    private String name;

    public ClientObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("[" + name + "] Current Temp is " + temperature + "°C");
    }

    @Override
    public String toString() {
        return name;
    }

}
