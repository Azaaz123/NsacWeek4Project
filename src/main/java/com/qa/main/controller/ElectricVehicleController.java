package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.entities.ElectricVehicle;

@RestController
public class ElectricVehicleController {
	
	/// Temporary storage
	
	private List<ElectricVehicle> cars = new ArrayList <>();
	
	 
	 //Get Requests (READ)
		@GetMapping("/getAll")
		public List<ElectricVehicle> getAll() {
			return cars ;
		}		
			
		// Post Requests (CREATE)
		 @PostMapping("/create")
		public ElectricVehicle create(@RequestBody ElectricVehicle input) {
			 cars.add(input);
			 
		return cars.get(cars.size () -1);
		
		 }
		 
		 @GetMapping("/getById/{id}")
			public ElectricVehicle getById(@PathVariable int id) {
				return cars.get(id);
			} 
			
		 
		 
}