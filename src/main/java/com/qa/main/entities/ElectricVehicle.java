package com.qa.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ElectricVehicle {

	@Entity
	public class ElectricVehicle {
		

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@Column(nullable=false)
		private String carMake;
		
		@Column(nullable=false)
		private String carModel;
		
		@Column(nullable=false)
		private int releaseYear;
		
		@Column(nullable=false)
		private int mileRange;
	
}

}