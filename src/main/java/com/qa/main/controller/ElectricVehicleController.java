package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.entities.ElectricVehicle;

@RestController
public class ElectricVehicleController {
	
	/// Temporary storage
	
	private List<ElectricVehicle> cars = new ArrayList <>();
	
	// 
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
		
	}

}