package com.qa.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.entities.ElectricVehicle;

@Repository
public class ElectricVehicleRepo extends JpaRepository<ElectricVehicle, Long> {

	
	
}
