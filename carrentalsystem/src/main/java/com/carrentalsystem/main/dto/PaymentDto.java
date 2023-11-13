package com.carrentalsystem.main.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PaymentDto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String paymentType;
	private double paymentPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", paymentType=" + paymentType + ", paymentPrice=" + paymentPrice + "]";
	}
	

}
