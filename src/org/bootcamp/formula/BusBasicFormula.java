package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public final class BusBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        int insurancePrice = vehicle.getAge() * 200;
        insurancePrice += vehicle.isDiesel() ? 1000 : 0;
        insurancePrice += vehicle.getNumberOfMiles() > 1000000 ? 500 : 0;
        insurancePrice += vehicle.getNumberOfMiles() > 2000000 ? 500 : 0;
        return insurancePrice;
    }
}
