package com.brq.EMotos.models;


public class AuthUserDTO {

	private int id;
	private String email;
	private String password;
	private String type;
	private String token;
	
	
	public AuthUserDTO() {}
	
	public AuthUserDTO(int id, String email, String type, String token) {
		this.id = id;
		this.email = email;
		this.type = type;
		this.token = token;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
}
