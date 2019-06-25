package com.revature.basics;

public class Trainee {
	/* Primitive Data Types */
	boolean ateBreakfast = true; //true and false are keywords
	byte age = 127; //-128 to 127
	char maritalStatus = 's';
	double gpa = 3.99;
	float debt = 12.58f;
	short petsOwned = 2; //small whole number
	int petsWant = 93; //larger whole number
	long idealSalaryInPennies = 20000000000L;
	
	/* String is NOT primitive */
	String name = "Minnie Mouse";
	
	public void casting() {
		//Implicit
		//this.maritalStatus = this.petsWant; //doesn't work
		//this.petsWant = this.maritalStatus; //works
		
		//Explicit
		this.maritalStatus = (char)this.petsWant;
		System.out.println(this.maritalStatus);
	}
}
