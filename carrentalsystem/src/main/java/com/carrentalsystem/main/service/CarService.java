package com.carrentalsystem.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Car;
import com.carrentalsystem.main.repository.CarRepository;

@Service
public class CarService {
@Autowired
private CarRepository carRepository;
	public Car insert(Car car) {
		return carRepository.save(car);
	}
	public Car getById(int carid) throws InvalidIdException {
		Optional<Car>optional=carRepository.findById(carid);
		if(!optional.isPresent())
			throw new InvalidIdException("car id is incorrect");
		return optional.get();
	}

}
