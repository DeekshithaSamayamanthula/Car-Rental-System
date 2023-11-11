package com.carrentalsystem.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	

	public Customer postCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
