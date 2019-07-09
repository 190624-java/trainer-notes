package com.revature.accessingVariables;

public class Driver {

	public static void main(String[] args) {
		MyClass myObject = new MyClass();
		System.out.println(myObject.publicString);//this will work
		try {
			//System.out.println(myObject.privateString); //causes compilation error. Can't recover
		} catch (Exception e) {
			System.out.println("You cannot access private variables unless you use public getter/setter methods!");
		}
		
		System.out.println(myObject.getPrivateString());
		
		myObject.publicString = "I have been changed";
		//myObject.privateString = "I can't be changed this way!";
		myObject.setPrivateString("I can be changed using the public setter method!");
		System.out.println(myObject.publicString);
		System.out.println(myObject.getPrivateString());
	}

}
