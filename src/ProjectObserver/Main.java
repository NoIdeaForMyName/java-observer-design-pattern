package ProjectObserver;

import Observable.InjectorsData;
import Observable.SpeedometerData;
import Observable.Subject;
import Observer.BodyControlComputer;
import Observer.OnboardComputer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        InjectorsData injectorsData = new InjectorsData();
        SpeedometerData speedometerData = new SpeedometerData();

        ArrayList<Subject> SubjectList = new ArrayList<>();
        SubjectList.add(speedometerData);//ZMIEN TO POTEM
        SubjectList.add(injectorsData);
        //(ArrayList<Subject>) Arrays.asList(injectorsData, speedometerData)

        OnboardComputer onboardComputer = new OnboardComputer(SubjectList);
        BodyControlComputer bodyControlComputer = new BodyControlComputer(SubjectList);

        System.out.println("Samochod odpalil wiec zaczynaja pracowac wtryskiwacze:");
        injectorsData.setMeasurements(0.12);

        System.out.println("\nPo chwili samochod rusza:");
        speedometerData.setMeasurements(25);
        injectorsData.setMeasurements(0.18);

        System.out.println("\nRozpedza sie bardziej, przez co zwieksza sie jego zapotrzebowanie na paliwo:");
        speedometerData.setMeasurements(100);
        injectorsData.setMeasurements(1.4);

        System.out.println("\nTeraz zakladam, ze zdarzyla sie awaria wtryskiwaczy i  podawane sa bledne wartosci:");
        injectorsData.setMeasurements(60);
        System.out.println("Zatem zapala sie kontrolka");

        System.out.println("\nTeraz przestaje monitorowac nieprawidlowosci i skupiam sie wylacznie na wskazaniach komputera pokladowego\nCzyli usuwam obserwatora BodyCtrlComp:");
        injectorsData.removeObserver(bodyControlComputer);
        speedometerData.removeObserver(bodyControlComputer);
        speedometerData.setMeasurements(80);
        injectorsData.setMeasurements(25);

    }
}
