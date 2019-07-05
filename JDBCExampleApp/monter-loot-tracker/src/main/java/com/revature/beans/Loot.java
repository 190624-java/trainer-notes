package com.revature.beans;

public class Loot {
	
	private int loot_id;
	private LootType loot_type;
	private String loot_name;
	private int loot_size;
	
	public Loot() {}
	
	public Loot(LootType loot_type, String loot_name, int loot_size) {
		super();
		this.loot_type = loot_type;
		this.loot_name = loot_name;
		this.loot_size = loot_size;
	}
	
	public Loot(int loot_id, LootType loot_type, String loot_name, int loot_size) {
		super();
		this.loot_id = loot_id;
		this.loot_type = loot_type;
		this.loot_name = loot_name;
		this.loot_size = loot_size;
	}

	public int getLoot_id() {
		return loot_id;
	}

	public void setLoot_id(int loot_id) {
		this.loot_id = loot_id;
	}

	public LootType getLoot_type() {
		return loot_type;
	}

	public void setLoot_type(LootType loot_type) {
		this.loot_type = loot_type;
	}

	public String getLoot_name() {
		return loot_name;
	}

	public void setLoot_name(String loot_name) {
		this.loot_name = loot_name;
	}

	public int getLoot_size() {
		return loot_size;
	}

	public void setLoot_size(int loot_size) {
		this.loot_size = loot_size;
	}
	
}
