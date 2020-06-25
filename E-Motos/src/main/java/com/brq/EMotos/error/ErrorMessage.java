package com.brq.EMotos.error;

import java.util.Date;


public class ErrorMessage {
	
	private Date currentDate;
	private String message;
	private int statusCode;

	public ErrorMessage() {}
	
	public ErrorMessage(Date currentDate, String message, int statusCode) {
		this.currentDate = currentDate;
		this.message = message;
		this.statusCode = statusCode;
	}
	
	
	public Date getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
