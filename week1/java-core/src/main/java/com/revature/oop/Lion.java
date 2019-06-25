package com.revature.oop;

public class Lion extends Cat implements Hunter{

	{
		System.out.println("Instantiated a Lion");
	}
	
	@Override
	public void speak() {
		System.out.println("ROAR!!!");
	}

	public void stalk(Animal animal) { }

	public void hunt(Animal animal) { }

}
