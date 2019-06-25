package com.revature.oop;

public class OOPDriver {

	public static void main(String[] args) {
		//driver method
		//Encapsulation
		Associate a = new Associate();
		a.setName("Minnie");
		a.setId(1);
		//a.age = -100;
		a.setAge(-100);
		System.out.println(a.getAge());
		
		//Abstraction & Inheritance
		Lion lion = new Lion();
		lion.speak();
		
		Animal lion2 = new Lion();
		//lion2.hunt(new Lion());
		Cat c = new Lion();
		c.speak();
		Lion c2 = (Lion)c;
		//Lion c2 = new Cat(); //doesn't work
		
		System.out.println("Polymorphism: ");
		
		//Polymorphism
		Lion l = new Lion();
		Cat cat = new Cat();
		
		Animal[] zoo = new Animal[3];
		zoo[0] = new Dog();
		zoo[1] = new Cat();
		zoo[2] = new Fish();
		
		for(int i = 0; i <zoo.length; i++) {
			Animal anim = zoo[i];
			anim.speak();
			if(anim instanceof Dog) {
				((Dog) anim).speak();
			}
		}
		
	}

}
