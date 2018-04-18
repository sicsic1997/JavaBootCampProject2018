package org.bootcamp;

import org.bootcamp.model.Bus;
import org.bootcamp.model.Car;
import org.bootcamp.model.Tipper;
import org.bootcamp.model.Vehicle;

public class MainApp {

    public static void main(String args[]) {

        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        System.out.println("Joe's policy cost is: " + joesCar.calculateInsurance());
        System.out.println("Steve's policy cost is: " + stevesBus.calculateInsurance());
        System.out.println("Peter's policy cost is: " + petersTipper.calculateInsurance());

    }

}
