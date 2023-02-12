package Observer;

import Observable.Subject;

import java.util.ArrayList;

public class BodyControlComputer implements Observer {

    private double fuel_flow_rate = 0.05; //  ml/s (initial)
    private double speed = 0; //    km/h
    private final int MAX_CORRECT_VALUE = 100;
    private final int ROAD_LENGTH = 100; //  km
    private final ArrayList<Subject> SubjectList;

    public BodyControlComputer(ArrayList<Subject> SubjectList) {
        this.SubjectList = SubjectList;
        for (Subject s : this.SubjectList)
            s.registerObserver(this);
    }

    public boolean IncorrectAmounts() {
        if (speed != 0)
            return (ROAD_LENGTH/speed * 3600 * (fuel_flow_rate /1000) >= MAX_CORRECT_VALUE);
        return false;
    }

    @Override
    public void update_inj(double fuel_flow_rate) {
        this.fuel_flow_rate = fuel_flow_rate;
        display();
    }

    @Override
    public void update_speed(double speed) {
        this.speed = speed;
        //display();
    }

    public void display() {
        System.out.println("Kontrolka Check Engine: " + IncorrectAmounts());
    }
}
