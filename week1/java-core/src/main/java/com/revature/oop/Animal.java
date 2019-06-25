package com.revature.oop;

public abstract class Animal {
	int legs;
	
	{
		System.out.println("Instantiated an Animal");
	}
	
	public void sleep() {
		System.out.println("ZzZz...");
	}
	
	public abstract void speak();
	
}
