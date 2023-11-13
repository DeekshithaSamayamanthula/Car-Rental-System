package com.carrentalsystem.main.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CarDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String carModel;
	private double price;
	private float mileage;
	
	private String fuelType;
	private int seating;
	private String insurance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getSeating() {
		return seating;
	}
	public void setSeating(int seating) {
		this.seating = seating;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	@Override
	public String toString() {
		return "CarDto [id=" + id + ", carModel=" + carModel + ", price=" + price + ", mileage=" + mileage
				+ ", fuelType=" + fuelType + ", seating=" + seating + ", insurance=" + insurance + "]";
	}
	
	

}
