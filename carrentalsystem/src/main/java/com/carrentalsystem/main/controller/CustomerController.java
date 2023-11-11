package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.model.Host;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.CustomerService;
import com.carrentalsystem.main.service.UserService;


@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService; 
	@PostMapping("/customer/post")
	public Customer postAdmin(@RequestBody Customer customer) { 
    User user = customer.getUser();
		String password = user.getPassword();
		String encodedpassword = passwordEncoder.encode(password);
		user.setPassword(encodedpassword);
		user.setRole("Customer");
		user = userService.insert(user);
		customer.setUser(user);
		customer = customerService.postCustomer(customer);		
		return customer;
}
	
	}
		
		
	
