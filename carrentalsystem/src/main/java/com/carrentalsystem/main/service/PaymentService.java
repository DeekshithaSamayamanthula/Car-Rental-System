package com.carrentalsystem.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.model.Payment;
import com.carrentalsystem.main.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment insert(Payment payment) {
		 return  paymentRepository.save(payment);
	}

}
