package com.carrentalsystem.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Host {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hostId;
	private String hostEmail;
	private String hostPass;
	private String hostName;
	private int hostContact;
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public String getHostEmail() {
		return hostEmail;
	}
	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}
	public String getHostPass() {
		return hostPass;
	}
	public void setHostPass(String hostPass) {
		this.hostPass = hostPass;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getHostContact() {
		return hostContact;
	}
	public void setHostContact(int hostContact) {
		this.hostContact = hostContact;
	}
	
}
