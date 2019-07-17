package com.revature.beans;

import com.revature.services.PetService;

public class Pet {

	private int id;
	private String name;
	private String type;
	
	public Pet() {}
	
	public Pet(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Pet(String name, String type) {
		this.id = PetService.pets.size()+1;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
