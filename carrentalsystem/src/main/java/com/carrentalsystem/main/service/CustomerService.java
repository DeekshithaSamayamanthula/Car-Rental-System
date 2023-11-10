package com.carrentalsystem.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Customer;
import com.carrentalsystem.main.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepository;
	
	public Customer insertCustomer(Customer customer) {
		
		return customerrepository.save(customer);
	}

	public Customer getOne(int id) throws InvalidIdException {
		Optional<Customer> optional =  customerrepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("Customer ID Invalid");
		}
		return optional.get();
	}

	public void deleteCustomer(Customer customer) {
		customerrepository.delete(customer);
		
	}

}
