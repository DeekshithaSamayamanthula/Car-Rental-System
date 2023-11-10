package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.CustomerService;
import com.carrentalsystem.main.service.UserService;


@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private UserService userService; 
	
	@PostMapping("/customer/post")
	public Customer insertCustomer(@RequestBody Customer customer) {
		customer = customerservice.insertCustomer(customer);
		User user = customer.getUser();
		user = userService.insert(user);
		customer.setUser(user);
		return customer;

		
		/* Attach the saved user(in step 1) to employee */
	}
	@DeleteMapping("/customer/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
		
		try {
			//validate id
			Customer customer = customerservice.getOne(id);
			//delete
			customerservice.deleteCustomer(customer);
			return ResponseEntity.ok().body("customer deleted successfully");

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/customer/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id) {

		try {
			Customer customer = customerservice.getOne(id);
			return ResponseEntity.ok().body(customer);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	}
		
		
	
