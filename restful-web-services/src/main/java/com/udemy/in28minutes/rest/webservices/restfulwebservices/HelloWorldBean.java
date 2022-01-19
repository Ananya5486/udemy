package com.udemy.in28minutes.rest.webservices.restfulwebservices;

public class HelloWorldBean {

	private String message;

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]",message);
	}
	
	
}
