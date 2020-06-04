package com.brq.EMotos.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String protocol;
	
	private boolean helmet;
	
	private long finalPrice;
	
	private boolean pickGarage;
	
	private boolean turnOverGarage;
	
	@OneToOne
	private Moto motoRentId;
	
	@OneToOne
	private User userRentId;
	
	@OneToOne
	private CreditCard creditCardRentId;
	
	@OneToOne
	private Address addressReceivementId;
	
	@OneToOne
	private Address addressRemovalId;
	
	
	// Gatters ans Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public boolean isHelmet() {
		return helmet;
	}

	public void setHelmet(boolean helmet) {
		this.helmet = helmet;
	}

	public long getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(long finalPrice) {
		this.finalPrice = finalPrice;
	}

	public boolean isPickGarage() {
		return pickGarage;
	}

	public void setPickGarage(boolean pickGarage) {
		this.pickGarage = pickGarage;
	}

	public boolean isTurnOverGarage() {
		return turnOverGarage;
	}

	public void setTurnOverGarage(boolean turnOverGarage) {
		this.turnOverGarage = turnOverGarage;
	}

	public Moto getMotoRentId() {
		return motoRentId;
	}

	public void setMotoRentId(Moto motoRentId) {
		this.motoRentId = motoRentId;
	}

	public User getUserRentId() {
		return userRentId;
	}

	public void setUserRentId(User userRentId) {
		this.userRentId = userRentId;
	}

	public CreditCard getCreditCardRentId() {
		return creditCardRentId;
	}

	public void setCreditCardRentId(CreditCard creditCardRentId) {
		this.creditCardRentId = creditCardRentId;
	}

	public Address getAddressReceivementId() {
		return addressReceivementId;
	}

	public void setAddressReceivementId(Address addressReceivementId) {
		this.addressReceivementId = addressReceivementId;
	}

	public Address getAddressRemovalId() {
		return addressRemovalId;
	}

	public void setAddressRemovalId(Address addressRemovalId) {
		this.addressRemovalId = addressRemovalId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
