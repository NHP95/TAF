package com.TAF.test.data;

public enum Message {
	LOGIN_SUCCESS("Welcome, "),
	LOGIN_FAIL("Incorrect credentials, please try again.")
	;
	
	private String text;
	
	private Message(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
}
