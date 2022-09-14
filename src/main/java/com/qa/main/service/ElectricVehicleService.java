package com.qa.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.entities.ElectricVehicle;
import com.qa.main.repo.ElectricVehicleRepo;

@Service
public class ElectricVehicleService {
	
	private List<ElectricVehicle> cars = new ArrayList <>();
	
	 

		public List<ElectricVehicle> getAll() {
			return cars ;
		}		
			

		public ElectricVehicle create( ElectricVehicle input) {
			 cars.add(input);
			 
		return cars.get(cars.size () -1);
		
		 }
		 

			public ElectricVehicle getById( int id) {
				return cars.get(id);
			} 
		 
		
			 	 
		 public ElectricVehicle update( int id, ElectricVehicle input) {
			 cars.remove(id);
			 cars.add(id, input);
			 return cars.get(id);
		 }
		 
	

		 public ElectricVehicle delete(int id) {
			return this.cars.remove(id);
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
