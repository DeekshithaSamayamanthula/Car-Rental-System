package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Car;
import com.carrentalsystem.main.model.Host;
import com.carrentalsystem.main.service.CarService;
import com.carrentalsystem.main.service.HostService;

@RestController
public class CarController {
	@Autowired
	private HostService hostService;
	@Autowired
	private CarService carService;
	
	@PostMapping("/car/post/{hid}")
	public ResponseEntity<?> postBook(@RequestBody Car car,@PathVariable("hid") int hid) {
		try {
			Host host = hostService.getById(hid);
			car.setHost(host);
			car=carService.insert(car);
			return ResponseEntity.ok().body(car);
			
		}	catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
				
		}
		
		/*catch (InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			*/
	}
}
