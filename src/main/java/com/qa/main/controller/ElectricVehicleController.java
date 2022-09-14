package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.entities.ElectricVehicle;

@RestController
public class ElectricVehicleController {
	

	 
	 //Get Requests (READ)
		@GetMapping("/getAll")
		public List<ElectricVehicle> getAll() {
				}		
			
		// Post Requests (CREATE)
		 @PostMapping("/create")
		public ElectricVehicle create(@RequestBody ElectricVehicle input) {

		 }
		 
		 @GetMapping("/getById/{id}")
			public ElectricVehicle getById(@PathVariable int id) {

			} 
		 
					
	 	 
		 @PutMapping("/update/{id}")
		 public ElectricVehicle update(@PathVariable int id, @RequestBody ElectricVehicle input) {

		 }
		 
	
			// Delete Requests (DELETE)
		 @DeleteMapping("/delete/{id}")
		 public ElectricVehicle delete(@PathVariable int id) {

		 }
		 
		 
		 
}