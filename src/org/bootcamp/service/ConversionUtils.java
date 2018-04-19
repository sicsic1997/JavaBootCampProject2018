package org.bootcamp.service;

import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.IOException;

final class ConversionUtils {

    private ConversionUtils() {
    }

    static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) throws IOException {

        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tippperClassName = Tipper.class.getSimpleName().toUpperCase();
        Vehicle vehicle = null;

        if(vehicleName.equals(carClassName)) {
            vehicle = new Car();
        }
        if(vehicleName.equals(busClassName)) {
            vehicle = new Bus();
        }
        if(vehicleName.equals(tippperClassName)) {
            vehicle = new Tipper();
        }
        if(vehicle == null) {
            return null;
        }

        vehicle.setAge(age);
        vehicle.setDiesel(isDiesel);
        vehicle.setNumberOfMiles(numberOfMiles);

        return vehicle;
    }

}
