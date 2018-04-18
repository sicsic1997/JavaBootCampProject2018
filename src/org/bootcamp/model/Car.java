package org.bootcamp.model;

public final class Car extends Vehicle{

    private String transmission;

    @Override
    public int calculateInsurance() {
        int insurancePrice =  100 * getAge();
        insurancePrice += isDiesel() ? 500 : 0;
        insurancePrice += (getNumberOfMiles() > 200000) ? 500 : 0;
        return insurancePrice;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Car(int age, long numberOfMiles, boolean isDiesel, String transmission) {
        super(age, numberOfMiles, isDiesel);
        this.transmission = transmission;
    }

    public Car() {
    }
}
