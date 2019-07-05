package com.revature.beans;
/*
 * A bean is a fully-encapsulated class that has only variables,
 * getters, setters, and constructors.
 */
public class Monster {
	//full encapsulated
	private int monster_id;
	private String monster_type;
	private int monster_level;
	
	//Constructors
	public Monster() {}
	
	public Monster(String monster_type, int monster_level) {
		super();
		this.monster_type = monster_type;
		this.monster_level = monster_level;
	}

	public Monster(int monster_id, String monster_type, int monster_level) {
		super();
		this.monster_id = monster_id;
		this.monster_type = monster_type;
		this.monster_level = monster_level;
	}

	//Getters and Setters
	public int getMonster_id() {
		return monster_id;
	}

	public void setMonster_id(int monster_id) {
		this.monster_id = monster_id;
	}

	public String getMonster_type() {
		return monster_type;
	}

	public void setMonster_type(String monster_type) {
		this.monster_type = monster_type;
	}

	public int getMonster_level() {
		return monster_level;
	}

	public void setMonster_level(int monster_level) {
		this.monster_level = monster_level;
	}
	
}
