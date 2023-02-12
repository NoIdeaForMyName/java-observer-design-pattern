package Observable;

import Observer.Observer;

import java.util.ArrayList;

public class SpeedometerData implements Subject {

    private final ArrayList<Observer> ObserverList = new ArrayList<>();
    private double speed;

    public void setMeasurements(double speed) {
        this.speed = speed;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : ObserverList)
            o.update_speed(speed);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }
}
