package com.revature.basics;

public class Constructor {

	public static void main(String[] args) {
		new Plate(5);
	}

}//end of Constructor

class Dish {
	int diameter;
	public Dish() {
		System.out.println("Dish 0-arg");
	}
}

class Plate extends Dish{
	public Plate() {
		//super();
		System.out.println("Plate 0-arg");
	}
	
	public Plate(int diameter) {
		this(); //constructor chaining
		System.out.println("Plate 1-arg");
		this.diameter = diameter;
	}
}
