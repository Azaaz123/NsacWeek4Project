package com.qa.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.main.entities.ElectricVehicle;


@Repository
public class ElectricVehicleRepo extends JpaRepository<ElectricVehicle, Long> {


	// SQL created // SELCT * FROM ElectricVehicle where car_make =?1
	List<ElectricVehicle> findElectricVehicleByCarMake(String carMake);
	List<ElectricVehicle> findElectricVehicleByCarModel(String carModel);
	List<ElectricVehicle> findElectricVehicleByReleaseYear(int releaseYear);
	List<ElectricVehicle> findElectricVehicleByMileRangeGreaterThan(int mileRange);
	
	} 
	
}
