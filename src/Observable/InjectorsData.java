package Observable;

import Observer.Observer;

import java.util.ArrayList;

public class InjectorsData implements Subject {

    private final ArrayList<Observer> ObserverList = new ArrayList<>();
    private double fuel_flow_rate;

    public void setMeasurements(double fuel_flow_rate) {
        this.fuel_flow_rate = fuel_flow_rate;
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
        for (Observer o : ObserverList)
            o.update_inj(fuel_flow_rate);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }
}
