package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String args[]) throws IOException {

        final VehicleDao vehicleDao = new VehicleInfoPlainFileDao(args[0]);
        List<VehicleInfo> vehicleInfoList = vehicleDao.getAllVehicles();

        if(vehicleInfoList.isEmpty()) {
            System.err.println("No records found");
            return;
        } else {
            for(VehicleInfo info: vehicleInfoList) {

                final Vehicle vehicle = getVehicle(
                        info.getVehicleTypeName(),
                        info.getAge(),
                        info.getNumberOfMiles(),
                        info.isDiesel()
                );
                final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());
                final int totalCost = calculator.calculate(vehicle, formula);
                final String output = String.format(OUTPUT_FORMAT, info.getId(), totalCost);
                System.out.println(output);

            }
        }


    }

    private static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) throws IOException {

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
