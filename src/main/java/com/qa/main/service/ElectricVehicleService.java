package com.qa.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.main.entities.ElectricVehicle;

@Service
public class ElectricVehicleService {
	
	private List<ElectricVehicle> cars = new ArrayList <>();
	
	 

		public List<ElectricVehicle> getAll() {
			return cars ;
		}		
			

		public ElectricVehicle create(@RequestBody ElectricVehicle input) {
			 cars.add(input);
			 
		return cars.get(cars.size () -1);
		
		 }
		 

			public ElectricVehicle getById(@PathVariable int id) {
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
		 
		 
}
