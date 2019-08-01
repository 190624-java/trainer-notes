package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.beans.Player;


public interface PlayerDAO {

	public List<Player> findAll();
	
	public void save(Player player);
}
