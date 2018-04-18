package org.bootcamp.model;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator() {};

    public int calculate(Car car) {

        int insurancePrice =  100 * car.getAge();
        insurancePrice += car.isDiesel() ? 500 : 0;
        insurancePrice += (car.getNumberOfMiles() > 200000) ? 500 : 0;
        return insurancePrice;

    }

    public int calculate(Bus bus) {

        int insurancePrice = bus.getAge() * 200;
        insurancePrice += bus.isDiesel() ? 1000 : 0;
        insurancePrice += bus.getNumberOfMiles() > 1000000 ? 500 : 0;
        insurancePrice += bus.getNumberOfMiles() > 2000000 ? 500 : 0;
        return insurancePrice;

    }

    public int calculate(Tipper tipper) {

        int insurancePrice = 300 * tipper.getAge();
        insurancePrice += tipper.getNumberOfMiles() > 80000 ? 700 : 0;
        return insurancePrice;

    }

}
