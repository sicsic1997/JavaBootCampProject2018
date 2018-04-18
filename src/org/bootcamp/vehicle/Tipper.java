package org.bootcamp.vehicle;

public final class Tipper extends Vehicle {

    private double capacityInTons;

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
