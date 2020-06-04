package com.brq.EMotos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String birthDate;
	
	@Column(unique=true)
	private String cpf;
	
	@Column(unique=true)
	private String cnh;
	
	private String password;
	
	private String cellPhone;
	
	private String type;
	
	private String statusRentUser;
	
	@OneToOne
	private Address addressUser;
	
	
	// Gatters ans Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(Address addressUser) {
		this.addressUser = addressUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatusRentUser() {
		return statusRentUser;
	}

	public void setStatusRentUser(String statusRentUser) {
		this.statusRentUser = statusRentUser;
	}
		
}
