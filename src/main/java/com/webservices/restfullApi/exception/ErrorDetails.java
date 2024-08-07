package com.webservices.restfullApi.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDate timestamp ; 
	private String message ; 
	private String details ;
	
	public ErrorDetails(LocalDate now, String message2, String description) {
		// TODO Auto-generated constructor stub
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	} 
	
	
}
