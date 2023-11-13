package com.carrentalsystem.main.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class CustomerCar { 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private LocalDate date;


@OneToOne
private Customer customer;

@OneToOne
private Car car;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

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

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

}
