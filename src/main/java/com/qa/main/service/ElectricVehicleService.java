package com.qa.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.entities.ElectricVehicle;
import com.qa.main.exceptions.ElectricVehicleNotFoundException;
import com.qa.main.repo.ElectricVehicleRepo;

@Service
public class ElectricVehicleService {
	
	private List<ElectricVehicle> cars = new ArrayList <>();
	
	 private ElectricVehicleRepo repo;
	 
	 
		public ElectricVehicleService(ElectricVehicleRepo repo) {
		super();
		this.repo = repo;
	}


		public List<ElectricVehicle> getAll() {
			return repo.findAll();
		}

		public ElectricVehicle  create(ElectricVehicle input) {
			return repo.saveAndFlush(input);
			
		 }
		 

		 public ElectricVehicle getById(long id) {
			 return repo.findById(id).orElseThrow(ElectricVehicleNotFoundException::new);
		 }
		 
		 public List<ElectricVehicle> getByCarMake(String carMake) {
			 return repo.findElectricVehicleByCarMake(carMake);	 
			 }
		 
		 public List<ElectricVehicle> getByCarModel(String carModel) {
			 return repo.findElectricVehicleByCarModel(carModel);	 
			 }
		 
		 public List<ElectricVehicle> getByReleaseYear(int releaseYear) {
			 return repo.findElectricVehicleByReleaseYear(releaseYear);	 
			 		 }
		 public List<ElectricVehicle> getByMileRangeGreaterThan(int mileRange) {
			 return repo.findElectricVehicleByMileRangeGreaterThan(mileRange);	 
			 		 }
		
			 	 
		 public ElectricVehicle update( long id, ElectricVehicle input) {
			 cars.remove(id);
			 cars.add(id, input);
			 return cars.get(id);
		 }
		 
	

	
		 
		 
}
