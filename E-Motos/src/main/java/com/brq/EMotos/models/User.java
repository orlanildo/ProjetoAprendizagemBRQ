package com.brq.EMotos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "{name.not.blank}")
	private String name;
	
	@Email(message = "{email.not.valid}")
	@NotBlank(message = "{email.not.blank}")
	@Column(unique=true)
	private String email;
	
	//@NotBlank
	//private String birthDate;
	
	@NotBlank
	@Column(unique=true)
	//@Size(min = 11, max = 11)
	private String cpf;
	
	@NotBlank
	@Column(unique=true)
	//@Size(min = 11, max = 11)
	private String cnh;
	
	@NotBlank(message = "{senha.not.blank}")
	private String password;
	
	@NotBlank
	//@Size(min = 11, max = 11)
	private String cellPhone;
	
	@NotBlank
	private String type;
	
	private boolean statusRentUser;
	
	@OneToOne
	private Address addressUser;
	
	private String rentProtocol;
	
	
	public User() {}
	
	public User(@NotBlank(message = "{name.not.blank}") String name,
			@Email(message = "{email.not.valid}") @NotBlank(message = "{email.not.blank}") String email,
			@NotBlank String cpf, @NotBlank String cnh, @NotBlank(message = "{senha.not.blank}")
			String password, @NotBlank String cellPhone, @NotBlank String type, Address addressUser) {
		
		//this.id = id;
		this.name = name;
		this.email = email;
		//this.birthDate = birthDate;
		this.cpf = cpf;
		this.cnh = cnh;
		this.password = password;
		this.cellPhone = cellPhone;
		this.type = type;
		//this.statusRentUser = statusRentUser;
		this.addressUser = addressUser;
		//this.rentProtocol = rentProtocol;
	}


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

	/*
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	 */
	
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

	public String getRentProtocol() {
		return rentProtocol;
	}

	public void setRentProtocol(String rentProtocol) {
		this.rentProtocol = rentProtocol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean getStatusRentUser() {
		return statusRentUser;
	}

	public void setStatusRentUser(boolean statusRentUser) {
		this.statusRentUser = statusRentUser;
	}

}
