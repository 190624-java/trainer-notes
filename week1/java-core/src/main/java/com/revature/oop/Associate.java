/**
 * 
 */
package com.revature.oop;

/**
 * @author Revature
 *
 */
public class Associate {

	private int id;
	private String name;
	private int age;
	
	public Associate() {
		super();
		this.id = 0;
		this.name = null;
		this.age = -1;
	}
	
	public Associate(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public void code() {
		System.out.println("coding...");
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		} else {
			System.out.println("Age must be greater than zero.");
		}
	}
	
	
}
