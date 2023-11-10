package com.carrentalsystem.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int adminId;
	private String adminName;
	private String email;
	private int phoneNo;
@OneToOne
private User user;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
