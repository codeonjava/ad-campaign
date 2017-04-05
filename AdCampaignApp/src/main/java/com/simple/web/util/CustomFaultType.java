package com.simple.web.util;

/**
 * Custom Fault message
 * 
 * @author puru
 *
 */
public class CustomFaultType {

	private String errorMessage;

	public CustomFaultType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
