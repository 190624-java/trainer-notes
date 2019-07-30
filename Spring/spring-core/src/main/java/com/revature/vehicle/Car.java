package com.revature.vehicle;

public class Car {

	//Spring Container will inject this property
	private Engine engine;
	private String model;
	
	//Setter injection
	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("engine: " + engine);
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void start() {
		System.out.println(model);
		engine.run();
	}
	
}
