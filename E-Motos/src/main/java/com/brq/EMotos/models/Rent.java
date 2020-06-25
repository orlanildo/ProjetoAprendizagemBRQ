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
	
	// colocar pra gerar automáticamente
	// colocar para ser único @Column(unique=true)
	private String protocol;
	
	private boolean helmet;
	
	private long finalPrice;
	
	private boolean pickGarage;
	
	private boolean turnOverGarage;
	
	@OneToOne
	private User userRentId;
	
	@OneToOne
	private Moto motoRentId;
	
	@OneToOne
	private CreditCard creditCardRentId;
	
	@OneToOne
	private Address addressReceivementId;
	
	@OneToOne
	private Address addressRemovalId;
	
	
	public Rent() {}
	
	public Rent(boolean helmet, long finalPrice, boolean pickGarage,
			boolean turnOverGarage, User userRentId, Moto motoRentId, 
			CreditCard creditCardRentId, Address addressReceivementId,
			Address addressRemovalId) {
		
		this.helmet = helmet;
		this.finalPrice = finalPrice;
		this.pickGarage = pickGarage;
		this.turnOverGarage = turnOverGarage;
		this.userRentId = userRentId;
		this.motoRentId = motoRentId;
		this.creditCardRentId = creditCardRentId;
		this.addressReceivementId = addressReceivementId;
		this.addressRemovalId = addressRemovalId;
	}

	
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

	public User getUserRentId() {
		return userRentId;
	}

	public void setUserRentId(User userRentId) {
		this.userRentId = userRentId;
	}
	
	public Moto getMotoRentId() {
		return motoRentId;
	}

	public void setMotoRentId(Moto motoRentId) {
		this.motoRentId = motoRentId;
	}

	public CreditCard getCreditCardRentId() {
		return creditCardRentId;
	}

	public void setCreditCardRentId(CreditCard creditCardRentId) {
		this.creditCardRentId = creditCardRentId;
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
	
	/*
	public String getCpfHolder() {
		return cpfHolder;
	}

	public void setCpfHolder(String cpfHolder) {
		this.cpfHolder = cpfHolder;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
	//temp
	public int getuserRentIdRentIdId() {
		return userRentIdRentIdId;
	}

	public void setuserRentIdRentIdId(int userRentIdRentIdId) {
		this.userRentIdRentIdId = userRentIdRentIdId;
	}

	public int getMotoId() {
		return motoId;
	}

	public void setMotoId(int motoId) {
		this.motoId = motoId;
	}

	public int getAddressReceivementId() {
		return addressReceivementId;
	}

	public void setAddressReceivementId(int addressReceivementId) {
		this.addressReceivementId = addressReceivementId;
	}

	public int getAddressRemovalId() {
		return addressRemovalId;
	}

	public void setAddressRemovalId(int addressRemovalId) {
		this.addressRemovalId = addressRemovalId;
	}
	*/
}
