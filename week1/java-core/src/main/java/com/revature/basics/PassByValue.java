package com.revature.basics;

public class PassByValue {
	/*
	 * as opposed to Pass By Reference
	 */

	public static void main(String[] args) {
		int x = 5;
		System.out.println(x);
		changeNumber(x);
		System.out.println(x);
		
		Trainee t = new Trainee();
		t.name = "Some Name";
		System.out.println(t.name);
		changeName(t);
		System.out.println(t.name);
		
		System.out.println(t);
		changeObject(t);
		System.out.println(t);
	}
	
	public static void changeNumber(int x) {
		x = 5_000_000;
		System.out.println("Changed Number: " + x);
	}
	
	public static void changeName(Trainee t) {
		t.name = "New Name";
		System.out.println("Trainee Name: " + t.name);
	}
	
	public static void changeObject(Trainee t) {
		t = new Trainee();
		System.out.println(t);
	}

}
