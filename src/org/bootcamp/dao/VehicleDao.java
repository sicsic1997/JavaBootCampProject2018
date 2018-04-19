package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;
import java.util.List;

public interface VehicleDao {

    List<VehicleInfo> getAllVehicles();

}
