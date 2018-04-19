package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public enum Formula {

    BUS_BASIC_FORMULA{
        @Override
        public int calculate(Vehicle vehicle) {
            int insurancePrice = vehicle.getAge() * 200;
            insurancePrice += vehicle.isDiesel() ? 1000 : 0;
            insurancePrice += vehicle.getNumberOfMiles() > 1000000 ? 500 : 0;
            insurancePrice += vehicle.getNumberOfMiles() > 2000000 ? 500 : 0;
            return insurancePrice;
        }
    },
    CAR_BASIC_FORMULA{
        @Override
        public int calculate(Vehicle vehicle) {
            int insurancePrice =  100 * vehicle.getAge();
            insurancePrice += vehicle.isDiesel() ? 500 : 0;
            insurancePrice += (vehicle.getNumberOfMiles() > 200000) ? 500 : 0;
            return insurancePrice;
        }
    },
    TIPPER_BASIC_FORMULA{
        @Override
        public int calculate(Vehicle vehicle) {
            int insurancePrice = 300 * vehicle.getAge();
            insurancePrice += vehicle.getNumberOfMiles() > 80000 ? 700 : 0;
            return insurancePrice;
        }
    };


    public abstract int calculate(Vehicle vehicle);

}
