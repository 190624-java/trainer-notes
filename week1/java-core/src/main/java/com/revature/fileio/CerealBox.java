package com.revature.fileio;

import java.io.Serializable;

public class CerealBox implements Serializable{

	private static final long serialVersionUID = 5141237738240796213L;
	
	boolean open;
	String brand;
	String name;
	transient int daysOpen;
	public CerealBox(boolean open, String brand, String name, int daysOpen) {
		super();
		this.open = open;
		this.brand = brand;
		this.name = name;
		this.daysOpen = daysOpen;
	}
	
	@Override
	public String toString() {
		return "CerealBox [open=" + open + ", brand=" + brand + ", name=" + name + ", daysOpen=" + daysOpen + "]";
	}
}
