package org.bootcamp.formula;
import org.bootcamp.vehicle.Vehicle;

public final class CarBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {

        int insurancePrice =  100 * vehicle.getAge();
        insurancePrice += vehicle.isDiesel() ? 500 : 0;
        insurancePrice += (vehicle.getNumberOfMiles() > 200000) ? 500 : 0;
        return insurancePrice;

    }
}
