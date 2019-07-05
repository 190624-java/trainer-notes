package com.revature.beans;

public class LootReceived {

	private int loot_received_id;
	private Loot loot;
	private MonsterHunt monster_hunt;
	private int quantity_received;
	
	public LootReceived() {}
	
	public LootReceived(Loot loot, MonsterHunt monster_hunt, int quantity_received) {
		super();
		this.loot = loot;
		this.monster_hunt = monster_hunt;
		this.quantity_received = quantity_received;
	}
	
	public LootReceived(int loot_received_id, Loot loot, MonsterHunt monster_hunt, int quantity_received) {
		super();
		this.loot_received_id = loot_received_id;
		this.loot = loot;
		this.monster_hunt = monster_hunt;
		this.quantity_received = quantity_received;
	}

	public int getLoot_received_id() {
		return loot_received_id;
	}

	public void setLoot_received_id(int loot_received_id) {
		this.loot_received_id = loot_received_id;
	}

	public Loot getLoot() {
		return loot;
	}

	public void setLoot(Loot loot) {
		this.loot = loot;
	}

	public MonsterHunt getMonster_hunt() {
		return monster_hunt;
	}

	public void setMonster_hunt(MonsterHunt monster_hunt) {
		this.monster_hunt = monster_hunt;
	}

	public int getQuantity_received() {
		return quantity_received;
	}

	public void setQuantity_received(int quantity_received) {
		this.quantity_received = quantity_received;
	}
	
}
