package com.carrentalsystem.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.model.Host;
import com.carrentalsystem.main.repository.HostRepository;

@Service
public class HostService {
@Autowired
private HostRepository hostRepository;
	public Host postHost(Host host) {
		// TODO Auto-generated method stub
		return hostRepository.save(host);
	}

}
