package com.TAF.test.data;

public enum Title {
	LOGIN("Login | PA Tool"),
	HOME("Home | PA Tool");
	
	private String text;
	
	private Title(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
}
