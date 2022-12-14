package com.qa.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

		public ElectricVehicle() {}
		
		public ElectricVehicle(String carMake, String carModel, int releaseYear, int mileRange) {
			super();
			this.carMake = carMake;
			this.carModel = carModel;
			this.releaseYear = releaseYear;
			this.mileRange = mileRange;
		}

		public ElectricVehicle(long id, String carMake, String carModel, int releaseYear, int mileRange) {
			super();
			this.id = id;
			this.carMake = carMake;
			this.carModel = carModel;
			this.releaseYear = releaseYear;
			this.mileRange = mileRange;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCarMake() {
			return carMake;
		}

		public void setCarMake(String carMake) {
			this.carMake = carMake;
		}

		public String getCarModel() {
			return carModel;
		}

		public void setCarModel(String carModel) {
			this.carModel = carModel;
		}

		public int getReleaseYear() {
			return releaseYear;
		}

		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}

		public int getMileRange() {
			return mileRange;
		}

		public void setMileRange(int mileRange) {
			this.mileRange = mileRange;
		}

		@Override
		public int hashCode() {
			return Objects.hash(carMake, carModel, id, mileRange, releaseYear);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ElectricVehicle other = (ElectricVehicle) obj;
			return Objects.equals(carMake, other.carMake) && Objects.equals(carModel, other.carModel) && id == other.id
					&& mileRange == other.mileRange && releaseYear == other.releaseYear;
		}
	
		
		
}

