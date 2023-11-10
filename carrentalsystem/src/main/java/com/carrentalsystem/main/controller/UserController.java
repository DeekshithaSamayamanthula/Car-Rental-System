package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.dto.UserDto;
import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService; // --DI

	@PostMapping("/user/post") 
	public User postUser(@RequestBody User user) { 
		
		user = userService.postUser(user);
		return user;
	}
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteuser(@PathVariable("id") int id) {
		
		try {
			
			User user = userService.getOne(id);
			
			userService.deleteUser(user);
			return ResponseEntity.ok().body("user deleted successfully");

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/user/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id) {

		try {
			User user = userService.getOne(id);
			return ResponseEntity.ok().body(user);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	@PutMapping("/user/update/{id}") 
	public ResponseEntity<?> updateUser(@PathVariable("id") int id,
							@RequestBody UserDto user2) {
		try {
		
			User user1 = userService.getOne(id);
			if(user2.getUsername() != null)
				user1.setUsername(user2.getUsername());
			if(user2.getEmailId() != null) 
				user1.setEmailId(user2.getEmailId()); 
			if(user2.getUserId() != 0) 
				user1.setUserId(user2.getUserId()); 
			if(user2.getPass() != null) 
				user1.setPass(user2.getPass()); 
			 
			user1 = userService.postUser(user1); 
			return ResponseEntity.ok().body(user1);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}

