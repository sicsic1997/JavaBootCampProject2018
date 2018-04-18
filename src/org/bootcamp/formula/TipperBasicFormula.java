package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public final class TipperBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        int insurancePrice = 300 * vehicle.getAge();
        insurancePrice += vehicle.getNumberOfMiles() > 80000 ? 700 : 0;
        return insurancePrice;
    }
}
