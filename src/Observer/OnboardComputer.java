package Observer;

import Observable.Subject;

import java.util.ArrayList;

public class OnboardComputer implements Observer {

    private double fuel_flow_rate = 0.05; //  ml/s (initial)
    private double speed = 0; // initial speed
    private String fuel_consumption;
    private final int ROAD_LENGTH = 100; //  km
    private final ArrayList<Subject> SubjectList;

    public OnboardComputer(ArrayList<Subject> SubjectList) {
        this.SubjectList = SubjectList;
        for (Subject s : this.SubjectList)
            s.registerObserver(this);
    }

    public void fuelConsumption() {
        if (speed != 0) {
            double time = ROAD_LENGTH / speed * 3600;
            fuel_consumption = Double.toString((double)(Math.round(time * (fuel_flow_rate / 1000)*100))/100);
        }
        else
            fuel_consumption = "-";
    }

    @Override
    public void update_inj(double fuel_flow_rate) {
        this.fuel_flow_rate = fuel_flow_rate;
        display_fuel_cons();
    }

    @Override
    public void update_speed(double speed) {
        this.speed = speed;
        display_speed();
    }

    public void display_fuel_cons() {
        fuelConsumption();
        System.out.println("Chwilowe Zuzycie paliwa: " + fuel_consumption + " l/100km");
    }

    public void display_speed() {
        System.out.println("Chwilowa predkosc: " + speed + " km/h");
    }

}
