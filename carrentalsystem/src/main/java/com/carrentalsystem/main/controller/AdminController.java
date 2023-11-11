package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.model.Admin;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.AdminService;
import com.carrentalsystem.main.service.UserService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/post") // api: /vendor/post --DI
	public Admin postAdmin(@RequestBody Admin admin) { // ur method is mapped to a URL : api
		/*
		 * I need vendor info as an object, and I will give it to repository via service
		 */
		User user = admin.getUser();
		String password = user.getPassword();
		String encodedpassword = passwordEncoder.encode(password);
		user.setPassword(encodedpassword);
		user.setRole("Admin");
		user = userService.insert(user);
		admin.setUser(user);
		admin = adminService.postAdmin(admin);
		
		return admin;
	}

}
