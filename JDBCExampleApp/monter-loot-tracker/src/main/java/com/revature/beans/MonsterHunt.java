package com.revature.beans;

public class MonsterHunt {
	
	private int monster_hunt_id;
	private Monster monster;
	private Player player;
	private int attack_multiplier;
	
	public MonsterHunt() {}
	
	public MonsterHunt(Monster monster, Player player, int attack_multiplier) {
		super();
		this.monster = monster;
		this.player = player;
		this.attack_multiplier = attack_multiplier;
	}
	
	public MonsterHunt(int monster_hunt_id, Monster monster, Player player, int attack_multiplier) {
		super();
		this.monster_hunt_id = monster_hunt_id;
		this.monster = monster;
		this.player = player;
		this.attack_multiplier = attack_multiplier;
	}

	public int getMonster_hunt_id() {
		return monster_hunt_id;
	}

	public void setMonster_hunt_id(int monster_hunt_id) {
		this.monster_hunt_id = monster_hunt_id;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getAttack_multiplier() {
		return attack_multiplier;
	}

	public void setAttack_multiplier(int attack_multiplier) {
		this.attack_multiplier = attack_multiplier;
	}

}
