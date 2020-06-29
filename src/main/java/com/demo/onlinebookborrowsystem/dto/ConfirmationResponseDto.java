package com.demo.onlinebookborrowsystem.dto;

public class ConfirmationResponseDto {
	
	String message;
	Integer statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	

}
