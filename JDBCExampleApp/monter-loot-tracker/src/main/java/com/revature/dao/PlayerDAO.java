package com.revature.dao;

import java.util.List;
import com.revature.beans.*;

public interface PlayerDAO {

	public Player createPlayer(Player player);
	
	public Player getPlayer(int player_id);
	public Player getPlayer(String username);
	public List<Player> getAllPlayers();
	public int getPlayerLevel(String username);
	
	public void updatePlayer(Player player);
	
	public void deletePlayer(Player player);
	
}
