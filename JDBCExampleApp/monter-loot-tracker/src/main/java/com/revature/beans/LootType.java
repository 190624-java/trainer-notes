package com.revature.beans;

public class LootType {

	private int loot_type_id;
	private String loot_type;
	
	public LootType() {}
	
	public LootType(String loot_type) {
		this.loot_type = loot_type;
	}
	
	public LootType(int loot_type_id, String loot_type) {
		this.loot_type_id = loot_type_id;
		this.loot_type = loot_type;
	}

	public int getLoot_type_id() {
		return loot_type_id;
	}

	public void setLoot_type_id(int loot_type_id) {
		this.loot_type_id = loot_type_id;
	}

	public String getLoot_type() {
		return loot_type;
	}

	public void setLoot_type(String loot_type) {
		this.loot_type = loot_type;
	}
	
}
