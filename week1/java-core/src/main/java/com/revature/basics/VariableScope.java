package com.revature.basics;

public class VariableScope {
	
}

class Trainee2 {
	static String trainer; //class scope
	String name; //instance scope
	
	public void speak(String words) {
		//words has method scope
		if (this.name != null) {
			String prefix = "[" + this.name + "] "; //block scope
			System.out.println(prefix + words);
		}
		//System.out.println(prefix);
	}
}