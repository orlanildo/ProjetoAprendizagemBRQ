package com.brq.EMotos.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class User {
	
	private String email;
	
	private String password;

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
