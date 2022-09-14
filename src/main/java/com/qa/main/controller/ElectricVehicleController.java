package com.qa.main.controller;

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
import com.qa.main.service.ElectricVehicleService;

@RestController
public class ElectricVehicleController {
	
	private ElectricVehicleService service;

		 
	 public ElectricVehicleController(ElectricVehicleService service) {
		super();
		this.service = service;
	}

	/// Get Requests (READ)
	@GetMapping("/getAll")
	public List<ElectricVehicle> getAll() {
		return service.getAll();
	}
			// Get Requests (READ)
	 
	// Get Requests (READ) - filtered IDs
	 
	@GetMapping("/getById/{id}")
	public ElectricVehicle getById(@PathVariable long id) {
		return service.getById(id);
	} 
	
	 
	 @GetMapping("/getByCarMake/{carMake}")
	 public List<ElectricVehicle> getByCarMake(@PathVariable String carMake) {
		 return service.getByCarMake(carMake);
			 }
	 
	
	 @GetMapping("/getByCarModel/{carModel}")
	 public List<ElectricVehicle> getByCarModel(@PathVariable String carModel) {
		 return service.getByCarModel(carModel);
			 }
	 
	 @GetMapping("/getByReleaseYear/{releaseYear}")
	 public List<ElectricVehicle> getByReleaseYear(@PathVariable int releaseYear) {
		 return service.getByReleaseYear(releaseYear);
					 }
	 
	 @GetMapping("/getByMileRangeGreaterThan/{mileRange}")
	 public List<ElectricVehicle> getByMileRangeGreaterThan(@PathVariable int mileRange) {
		 return service.getByMileRangeGreaterThan(mileRange);
					 }
	
	
	// Post Requests (CREATE)
	 @PostMapping("/create")
	public ResponseEntity<ElectricVehicle> create(@RequestBody ElectricVehicle input) {
		 return new ResponseEntity<ElectricVehicle>(service.create(input), HttpStatus.CREATED);
	 }
	 
		 	 
	 @PutMapping("/update/{id}")
	 public ElectricVehicle update(@PathVariable long id, @RequestBody ElectricVehicle input) {
		 return service.update(id, input);
	 }
	 
	// Delete Requests (DELETE)
	 @DeleteMapping("/delete/{id}")
	 public boolean delete(@PathVariable long id) {
		return service.delete(id);
	 }
}