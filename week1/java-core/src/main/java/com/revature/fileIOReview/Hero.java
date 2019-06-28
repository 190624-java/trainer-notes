package com.revature.fileIOReview;

import java.io.Serializable;

public class Hero implements Serializable{

	private static final long serialVersionUID = 6065057284932269995L;
	
	public String name;
	public String element;
	public String heroClass;
	public int level;
	
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	
	public Hero(String name, String element, String heroClass, int level) {
		super();
		this.name = name;
		this.element = element;
		this.heroClass = heroClass;
		this.level = level;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
