package com.TAF.test.data;

public enum URL {
	LOGIN("http://192.168.74.25/patest/Home/Login/"),
	HOME("http://192.168.74.25/patest/");
	
	private String text;
	
	private URL(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
}
