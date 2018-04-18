package org.bootcamp.model;

public final class Car extends Vehicle{

    private String transmission;

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
