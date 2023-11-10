package com.carrentalsystem.main.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	private int age;
	private String city;
	private String area;
	private LocalDate date;

@OneToOne
private User user;
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
