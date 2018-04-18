package org.bootcamp;

import org.bootcamp.model.*;

public class MainApp {

    public static void main(String args[]) {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final Car joesCar = new Car(5, 200000, true, "auto");
        final Bus stevesBus = new Bus(3, 100000, true, 31);
        final Tipper petersTipper = new Tipper(6, 80000, false, 15);

        System.out.println("Joe's policy cost is: " + calculator.calculate(joesCar));
        System.out.println("Steve's policy cost is: " + calculator.calculate(stevesBus));
        System.out.println("Peter's policy cost is: " + calculator.calculate(petersTipper));

    }

}
