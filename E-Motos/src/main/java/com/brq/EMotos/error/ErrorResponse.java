package com.brq.EMotos.error;

public class ErrorResponse extends Exception {

	private static final long serialVersionUID = 1L;
	

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorResponse(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorResponse(String message) {
		super(message);
	}

	public ErrorResponse(Throwable cause) {
		super(cause);
	}
	
	
}
