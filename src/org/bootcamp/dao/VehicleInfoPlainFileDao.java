package org.bootcamp.dao;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleInfoPlainFileDao implements VehicleDao {

    private final String filePath;
    private final static String SEPARATOR = ";";
    private final static int VEHICLE_ID = 0;
    private final static int VEHICLE_TYPE = 1;
    private final static int VEHICLE_NAME = 2;
    private final static int VEHICLE_AGE = 3;
    private final static int VEHICLE_MILES = 4;
    private final static int VEHICLE_IS_DIESEL = 5;

    public VehicleInfoPlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {

        List<VehicleInfo> vehicleInfos = new ArrayList<>();
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        if(filePath.length() >= 1) {
            final File inputFile = new File(filePath);
            try {
                final InputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputFile);

                while (scanner.hasNext()) {

                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);
                    VehicleInfo vehicleInfo = new VehicleInfo(
                            tokens[VEHICLE_ID],
                            tokens[VEHICLE_TYPE],
                            tokens[VEHICLE_NAME],
                            Integer.parseInt(tokens[VEHICLE_AGE]),
                            Long.parseLong(tokens[VEHICLE_MILES]),
                            Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])
                    );
                    vehicleInfos.add(vehicleInfo);

                }
                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No arguments");
        }

        return vehicleInfos;

    }


}
