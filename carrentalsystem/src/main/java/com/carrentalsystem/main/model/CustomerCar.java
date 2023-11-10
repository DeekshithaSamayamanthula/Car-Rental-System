package com.carrentalsystem.main.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class CustomerCar {
	@Id
	private LocalDateTime date;


@OneToOne
private Customer customer;

@OneToOne
private Car car;

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Car getCar() {
	return car;
}

public void setCar(Car car) {
	this.car = car;
}

public LocalDateTime getDate() {
	return date;
}

public void setDate(LocalDateTime date) {
	this.date = date;
}

}
