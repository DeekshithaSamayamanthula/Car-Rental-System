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

import com.carrentalsystem.main.dto.AdminDto;
import com.carrentalsystem.main.dto.CarDto;
import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Admin;
import com.carrentalsystem.main.model.Car;
import com.carrentalsystem.main.model.Host;
import com.carrentalsystem.main.service.CarService;
import com.carrentalsystem.main.service.HostService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private HostService hostService;
	@Autowired
	private CarService carService;
	
	@PostMapping("/post/{hid}")
	public ResponseEntity<?> postCar(@RequestBody Car car,@PathVariable("hid") int hid) {
		try {
			Host host = hostService.getById(hid);
			car.setHost(host);
			car=carService.insert(car);
			return ResponseEntity.ok().body(car);
			
		}	catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
				
		}
		
		
		
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getone(@PathVariable("id")int id) throws InvalidIdException {
		try {
	    Car car = carService.getByCarId(id);
		return ResponseEntity.ok().body(car);
	}
	catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
			
	}
}
	
	@GetMapping("/getall") /// vendor/getall?page=0&size=10
	public List<Car> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return carService.getAll(pageable);
	}
	@PutMapping("/update/{carid}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateCar(@PathVariable("carid") int carid,
							@RequestBody CarDto newCar) throws InvalidIdException {
		//validate id
		Car oldCar = carService.getById(carid);
		
		if(newCar.getCarModel()!= null)
			oldCar.setCarModel(newCar.getCarModel ());
		
		if(newCar.getPrice()!=0) 
			oldCar.setPrice(newCar.getPrice()); 
		
		if(newCar.getMileage()!= 0)
			oldCar.setMileage(newCar.getMileage());
		
		if(newCar.getFuelType()!= null)
			oldCar.setFuelType(newCar.getFuelType());
		
		if(newCar.getSeating()!= 0)
			oldCar.setSeating(newCar.getSeating());
		
		if(newCar.getInsurance()!= null)
			oldCar.setInsurance(newCar.getInsurance());
		 
		oldCar = carService.insert(oldCar); 
		return ResponseEntity.ok().body(oldCar);
	}
	@DeleteMapping("/delete/{carid}")
	public ResponseEntity<?> deleteCar(@PathVariable("carid") int carid) {
		try {
			 Car car = carService.getById(carid);
			carService.deleteCar(carid);
			return ResponseEntity.ok().body("Car Is deleted");
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
