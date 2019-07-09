package com.revature.accessingVariables;

public class MyClass {

	public String publicString;
	private String privateString;
	
	public MyClass() {
		this.publicString = "Hello";
		this.privateString = "World";
	}

	public String getPrivateString() {
		return privateString;
	}

	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
	
	
	
}
