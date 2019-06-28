package com.revature.designPatterns.dao;
/*
 * pojo - plain ol' java object
 * 		- contain member variables, getters and setters, constructors
 * 		- also sometimes referred to as a 'bean'
 */
public class User {

	public int id;
	public String name;
	
	public User(String name) {
		this.name = name;
	}
	
}
