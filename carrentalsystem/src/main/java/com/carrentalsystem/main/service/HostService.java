package com.carrentalsystem.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.main.exception.InvalidIdException;
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
	public Host getById(int hid) throws InvalidIdException {
		Optional<Host> optional =hostRepository.findById(hid);
		if(!optional.isPresent())
			throw new InvalidIdException("Host id Invalid");
		return optional.get();
	}

}
