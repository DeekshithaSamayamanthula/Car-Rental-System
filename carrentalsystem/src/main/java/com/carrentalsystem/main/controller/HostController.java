package com.carrentalsystem.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> de4590bc370118484e30787760ad23f9c3f2dc48
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.main.dto.HostDto;
import com.carrentalsystem.main.exception.InvalidIdException;
import com.carrentalsystem.main.model.Admin;
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
	@PutMapping("/update/{hid}")
	public ResponseEntity<?> updateHost(@PathVariable("hid") int hid,@RequestBody HostDto hostDto){
		try {
			Host host = hostService.getById(hid);
			if(hostDto.getHostEmail()!=null)
				host.setHostEmail(hostDto.getHostEmail());
			if(hostDto.getHostName()!=null)
				host.setHostName(hostDto.getHostName());
			if(hostDto.getHostContact()!=null)
				host.setHostContact(hostDto.getHostContact());
			host= hostService.postHost(host);
			return ResponseEntity.ok().body(host);	
		}catch(InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHost(@PathVariable("id") int id) throws InvalidIdException {
		
		//validate id
		Host host = hostService.getOne(id);
		//delete
		hostService.deleteHost(host);
		return ResponseEntity.ok().body("Host deleted successfully");
	}
}
