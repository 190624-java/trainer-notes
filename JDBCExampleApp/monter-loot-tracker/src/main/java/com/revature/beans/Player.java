package com.revature.beans;

public class Player {

	private int player_id;
	private String username;
	private int player_level;
	
	public Player() {}
	
	public Player(String username, int player_level) {
		super();
		this.username = username;
		this.player_level = player_level;
	}

	public Player(int player_id, String username, int player_level) {
		super();
		this.player_id = player_id;
		this.username = username;
		this.player_level = player_level;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPlayer_level() {
		return player_level;
	}

	public void setPlayer_level(int player_level) {
		this.player_level = player_level;
	}

	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", username=" + username + ", player_level=" + player_level + "]";
	}
	
}
