package com.spring.SpringBootApp.exception;

public class commonErrorMessage {
	private int statusCode;
	private String messge;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}

	public String getMessge() {
		return messge;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public commonErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public commonErrorMessage(int statusCode, String messge) {
		super();
		this.statusCode = statusCode;
		this.messge = messge;
	}

}
