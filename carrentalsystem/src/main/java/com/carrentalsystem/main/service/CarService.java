package com.carrentalsystem.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.model.Car;
import com.carrentalsystem.main.repository.CarRepository;

@Service
public class CarService {
@Autowired
private CarRepository carRepository;
	public Car insert(Car car) {
		return carRepository.save(car);
	}

}
