package org.bootcamp.service;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.bootcamp.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {

    static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
    private String filePath;

    public InsuranceCalculatorService(String filePath) {
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculateAll() throws IOException {

        final VehicleDao vehicleDao = new VehicleInfoPlainFileDao(filePath);
        List<InsuranceCalculationResult> calculationResultList = new ArrayList<>();
        List<VehicleInfo> vehicleInfoList = vehicleDao.getAllVehicles();

        if(vehicleInfoList.isEmpty()) {
            System.err.println("No records found");
            return Collections.emptyList();
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
                calculationResultList.add(new InsuranceCalculationResult(info.getId(), totalCost));

            }
        }

        return calculationResultList;

    };

}
