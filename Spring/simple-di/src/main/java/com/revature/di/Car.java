package com.revature.di;

public class Car {

	//private Engine engine = new ElectricEngine();
	private Engine engine = (Engine) BeanFactory.getBean("engine");
	
	public void start() {
		engine.run();
	}
	
	public static void main(String[] args) {
		new Car().start();
	}
	
}
