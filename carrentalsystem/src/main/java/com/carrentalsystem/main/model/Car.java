package com.carrentalsystem.main.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", price=" + price + ", mileage=" + mileage
				+ ", fuelType=" + fuelType + ", seating=" + seating + ", insurance=" + insurance + ", host=" + host
				+ "]";
	}
	private String carModel;
	private double price;
	private float mileage;
	
	private String fuelType;
	private int seating;
	private String insurance;
	
@OneToOne
private Host host;
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
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
public String isInsurance() {
	return insurance;
}
public void setInsurance(String insurance) {
	this.insurance = insurance;
}
public Host getHost() {
	return host;
}
public void setHost(Host host) {
	this.host = host;
}

}
