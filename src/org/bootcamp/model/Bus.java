package org.bootcamp.model;

public final class Bus extends Vehicle {

    private int numberOfSeats;

    @Override
    public int calculateInsurance() {

        int insurancePrice = getAge() * 200;
        insurancePrice += isDiesel() ? 1000 : 0;
        insurancePrice += getNumberOfMiles() > 1000000 ? 500 : 0;
        insurancePrice += getNumberOfMiles() > 2000000 ? 500 : 0;
        return insurancePrice;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numberOfSeats) {
        super(age, numberOfMiles, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public Bus() {
    }
}
