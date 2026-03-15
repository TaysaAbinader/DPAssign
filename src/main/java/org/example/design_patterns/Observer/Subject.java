package org.example.design_patterns.Observer;

public interface Subject {
    void registerSubject(WeatherObserver observer);
    void removeSubject(WeatherObserver observer);
    void notifySubjects();
}
