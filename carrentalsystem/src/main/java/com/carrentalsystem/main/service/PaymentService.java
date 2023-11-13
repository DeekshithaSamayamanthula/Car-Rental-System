package com.carrentalsystem.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.model.Payment;
import com.carrentalsystem.main.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment insert(Payment payment) {
		 return  paymentRepository.save(payment);
	}

	public Payment getByPaymentId(int pid) throws InvalidIdException {
		Optional<Payment> optional=paymentRepository.findById(pid);
		if(!optional.isPresent())
			throw new InvalidIdException("payment id invalid");
				return optional.get();
	}

	public List<Payment> getAll(Pageable pageable) {
		return paymentRepository.findAll(pageable).getContent();
		 
	}

	public void deletePayment(int pid) {
		 paymentRepository.deleteById(pid);
	
}
}

