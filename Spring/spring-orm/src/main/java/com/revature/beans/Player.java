package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@Column(name = "player_id")
	private int playerId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "player_level")
	private int playerLevel;

	public Player() {
	}

	public Player(int playerId, String username, int playerLevel) {
		super();
		this.playerId = playerId;
		this.username = username;
		this.playerLevel = playerLevel;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", username=" + username + ", playerLevel=" + playerLevel + "]";
	}
}
