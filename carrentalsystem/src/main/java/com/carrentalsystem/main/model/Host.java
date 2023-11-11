package com.carrentalsystem.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Host {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hostId;
	private String hostEmail;
	private String hostPass;
	private String hostName;
	private String hostContact;
	@OneToOne
	private User user; 
	@Override
	public String toString() {
		return "Host [hostId=" + hostId + ", hostEmail=" + hostEmail + ", hostPass=" + hostPass + ", hostName="
				+ hostName + ", hostContact=" + hostContact + ", user=" + user + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String getHostContact() {
		return hostContact;
	}
	public void setHostContact(String hostContact) {
		this.hostContact = hostContact;
	}
	
}
