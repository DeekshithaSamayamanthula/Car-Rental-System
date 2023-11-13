package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.model.Host;
import com.carrentalsystem.main.model.User;
import com.carrentalsystem.main.service.HostService;
import com.carrentalsystem.main.service.UserService;

@RestController
@RequestMapping("/host")
public class HostController {
	@Autowired
	private HostService hostService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@PostMapping("/post")
	public Host postAdmin(@RequestBody Host host) { 
    User user = host.getUser();
		String password = user.getPassword();
		String encodedpassword = passwordEncoder.encode(password);
		user.setPassword(encodedpassword);
		user.setRole("Host");
		user = userService.insert(user);
		host.setUser(user);
		host = hostService.postHost(host);		
		return host;
}
	}
