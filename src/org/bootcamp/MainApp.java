package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String args[]) throws IOException {

        if(args.length < 1) {
            System.err.println("No file given");
        } else {
            final InsuranceCalculatorService insuranceCalculatorService = new InsuranceCalculatorService(args[0]);
            final List<InsuranceCalculationResult> insuranceCalculationResults = insuranceCalculatorService.calculateAll();

            for (InsuranceCalculationResult result:insuranceCalculationResults) {

                final String output = String.format(OUTPUT_FORMAT, result.getId(), result.getCost());
                System.out.println(output);

            }

        }

    }


}
