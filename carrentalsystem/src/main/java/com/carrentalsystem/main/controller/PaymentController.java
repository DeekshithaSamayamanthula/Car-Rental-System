package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.model.Payment;
import com.carrentalsystem.main.service.CustomerService;
import com.carrentalsystem.main.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/add/{cid}")
	public ResponseEntity<?> insertPayment(@PathVariable("cid")int cid,
			@RequestBody Payment payment){
	try{
		
		Customer customer = customerService.getById(cid);
		
		payment.setCustomer(customer);
		
		payment = paymentService.insert(payment);
		return ResponseEntity.ok().body(payment);
	} catch(InvalidIdException e) {
		
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}

}
