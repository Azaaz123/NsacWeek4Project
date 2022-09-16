package com.qa.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.entities.ElectricVehicle;
import com.qa.main.exceptions.ElectricVehicleNotFoundException;
import com.qa.main.repo.ElectricVehicleRepo;

@Service
public class ElectricVehicleService {
	
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
		 
		
			 	 
		 public ElectricVehicle update(long id, ElectricVehicle input) {
			 ElectricVehicle existing = repo.findById(id).orElseThrow(ElectricVehicleNotFoundException::new);
			 
			 existing.setCarMake(input.getCarMake());
			 existing.setCarModel(input.getCarModel());
			 existing.setReleaseYear(input.getReleaseYear());
			 existing.setMileRange(input.getMileRange());
			 
			return repo.saveAndFlush(existing);
			
		 }	
		 
		 public boolean delete(long id) {
			 // Deletes the entry by ID
			 repo.deleteById(id);
			 
			// Checks if entry exists by ID
			 return !repo.existsById(id);
			 
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
		 
		 
}

