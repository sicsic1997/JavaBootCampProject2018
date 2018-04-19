package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.formula.Formula;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.*;
import java.text.Normalizer;
import java.util.Scanner;

public class MainApp {

    final static String SEPARATOR = ";";
    final static int VEHICLE_ID = 0;
    final static int VEHICLE_TYPE = 1;
    final static int VEHICLE_NAME = 2;
    final static int VEHICLE_AGE = 3;
    final static int VEHICLE_MILES = 4;
    final static int VEHICLE_IS_DIESEL = 5;
    final static String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String args[]) {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        if(args.length >= 1) {
            final File inputFile = new File(args[0]);
            try {
                final InputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputFile);

                while (scanner.hasNext()) {

                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);
                    Vehicle vehicle = getVehicle(
                            tokens[VEHICLE_TYPE],
                            Integer.parseInt(tokens[VEHICLE_AGE]),
                            Long.parseLong(tokens[VEHICLE_MILES]),
                            Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                    final Formula formula = Formula.valueOf(tokens[VEHICLE_NAME]);
                    final int totalCost = calculator.calculate(vehicle, formula);
                    final String output = String.format(OUTPUT_FORMAT, tokens[VEHICLE_ID], totalCost);
                    System.out.println(output);

                }

                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No arguments");
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
