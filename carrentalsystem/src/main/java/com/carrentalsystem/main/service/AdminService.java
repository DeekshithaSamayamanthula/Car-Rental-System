package com.carrentalsystem.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.model.Admin;
import com.carrentalsystem.main.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired 
	private AdminRepository adminRepository;
	public Admin postAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

}
