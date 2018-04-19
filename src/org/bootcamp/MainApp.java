package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.formula.*;
import org.bootcamp.vehicle.*;


public class MainApp {

    public static void main(String args[]) {

        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        System.out.println("Joe's policy cost is: " + calculator.calculate(joesCar, Formula.CAR_BASIC_FORMULA));
        System.out.println("Steve's policy cost is: " + calculator.calculate(stevesBus, Formula.BUS_BASIC_FORMULA));
        System.out.println("Peter's policy cost is: " + calculator.calculate(petersTipper, Formula.TIPPER_BASIC_FORMULA));

    }

}
