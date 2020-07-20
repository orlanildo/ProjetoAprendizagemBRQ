package com.brq.EMotos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Moto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String brand;
	
	private String model;
	
	//private String version;
	
	@Column(unique=true)
	private String licensePlate;
	
	private long displacement;
	
	private String year;
	
	private long km;
	
	private String description;
	
	private float pricePerKm;
	
	private String photoMoto;
	
	private boolean statusRent;
	
	
	public Moto() {}
	
	public Moto(String name, String brand, String model, String licensePlate,
			long displacement, String year, long km, String description, 
			float pricePerKm, String photoMoto) {
		
		//this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		//this.version = version;
		this.licensePlate = licensePlate;
		this.displacement = displacement;
		this.year = year;
		this.km = km;
		this.description = description;
		this.pricePerKm = pricePerKm;
		this.photoMoto = photoMoto;
		//this.statusRent = statusRent;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	/*
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	*/

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public long getDisplacement() {
		return displacement;
	}

	public void setDisplacement(long displacement) {
		this.displacement = displacement;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(float pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	public String getPhotoMoto() {
		return photoMoto;
	}

	public void setPhotoMoto(String photoMoto) {
		this.photoMoto = photoMoto;
	}

	public boolean getStatusRent() {
		return statusRent;
	}

	public void setStatusRent(boolean statusRent) {
		this.statusRent = statusRent;
	}
	
}
