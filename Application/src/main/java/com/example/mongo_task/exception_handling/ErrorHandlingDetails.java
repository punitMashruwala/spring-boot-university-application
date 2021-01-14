package com.example.mongo_task.exception_handling;

import java.util.Date;

public class ErrorHandlingDetails {
	private Date timestamp;
	private String errorMessage;
	private int statusCode;
	private String errorDetails;
	
	
	
	public ErrorHandlingDetails(Date timestamp, String errorMessage, int statusCode, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.errorDetails = errorDetails;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
