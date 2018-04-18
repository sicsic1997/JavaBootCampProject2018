package org.bootcamp.model;

public final class Tipper extends Vehicle {

    private double capacityInTons;

    @Override
    public int calculateInsurance() {

        int insurancePrice = 300 * getAge();
        insurancePrice += getNumberOfMiles() > 80000 ? 700 : 0;
        return insurancePrice;

    }

    public double getCapacityInTons() {
        return capacityInTons;
    }

    public void setCapacityInTons(double capacityInTons) {
        this.capacityInTons = capacityInTons;
    }

    public Tipper(int age, long numberOfMiles, boolean isDiesel, double capacityInTons) {
        super(age, numberOfMiles, isDiesel);
        this.capacityInTons = capacityInTons;
    }

    public Tipper() {
    }
}
