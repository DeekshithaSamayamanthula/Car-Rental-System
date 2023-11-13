package com.carrentalsystem.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Admin;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.AdminService;
import com.carrentalsystem.main.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	
	@PostMapping("/post") // api: /vendor/post --DI
	public Admin postAdmin(@RequestBody Admin admin) { // ur method is mapped to a URL : api
		
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
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getone(@PathVariable("id")int id) throws InvalidIdException {
	    Admin admin = adminService.getOne(id);
		return ResponseEntity.ok().body(admin);
	}
	@GetMapping("/getall") /// vendor/getall?page=0&size=10
	public List<Admin> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return adminService.getAll(pageable);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) throws InvalidIdException {
		
		//validate id
		Admin admin = adminService.getOne(id);
		//delete
		adminService.deleteAdmin(admin);
		return ResponseEntity.ok().body("Admin deleted successfully");
	}
	@PutMapping("/update/{id}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int id,
							@RequestBody AdminDto newAdmin) throws InvalidIdException {
		//validate id
		Admin oldAdmin = adminService.getOne(id);
		
		if(newAdmin.getAdminName() != null)
			oldAdmin.setAdminName(newAdmin.getAdminName());
		if(newAdmin.getEmail() != null) 
			oldAdmin.setEmail(newAdmin.getEmail()); 
		if(newAdmin.getPhoneNo() != null)
			oldAdmin.setPhoneNo(newAdmin.getPhoneNo());
		 
		oldAdmin = adminService.postAdmin(oldAdmin); 
		return ResponseEntity.ok().body(oldAdmin);
	}
}
