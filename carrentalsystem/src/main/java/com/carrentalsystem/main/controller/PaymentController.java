package com.carrentalsystem.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.dto.CarDto;
import com.carrentalsystem.main.dto.PaymentDto;
import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Car;
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
	@GetMapping("/getone/{pid}")
	public ResponseEntity<?> getone(@PathVariable("pid")int pid) throws InvalidIdException {
		try {
	     Payment payment =paymentService.getByPaymentId(pid);
		return ResponseEntity.ok().body(payment);
	}
	catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
			
	}
}
	
	@GetMapping("/getall") /// vendor/getall?page=0&size=10
	public List<Payment> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return paymentService.getAll(pageable);
	}
	@PutMapping("/update/{pid}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updatePayment(@PathVariable("pid") int pid,
							@RequestBody PaymentDto newPayment) throws InvalidIdException {
		//validate id
		Payment oldpayment = paymentService.getByPaymentId(pid);
		
		if(newPayment.getPaymentPrice()!= 0)
			oldpayment.setPaymentPrice(newPayment.getPaymentPrice());

		if(newPayment.getPaymentType()!= null)
			oldpayment.setPaymentType(newPayment.getPaymentType());
		
		
		
		 
		oldpayment =paymentService.insert(oldpayment); 
		return ResponseEntity.ok().body(oldpayment);
	}
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deletePayment(@PathVariable("pid") int pid) {
		try {
			 Payment payment = paymentService.getByPaymentId(pid);
			paymentService.deletePayment(pid);
			return ResponseEntity.ok().body("Payment Is deleted");
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
