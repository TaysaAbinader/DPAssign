package Observer;

public interface Subject {
    void registerSubject(WeatherObserver observer);
    void removeSubject(WeatherObserver observer);
    void notifySubjects();
}
