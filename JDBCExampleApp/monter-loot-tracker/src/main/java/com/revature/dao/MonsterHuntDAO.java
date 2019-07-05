package com.revature.dao;

import com.revature.beans.*;
import java.util.List;

public interface MonsterHuntDAO {

	public MonsterHunt createMonsterHunt(MonsterHunt hunt);
	public LootReceived createLootReceived(LootReceived loot_received);
	
	public MonsterHunt getMonsterHunt(int hunt_id);
	public List<MonsterHunt> getMonsterHuntsByMonster(Monster monster);
	public List<MonsterHunt> getMonsterHuntsByPlayer(Player player);
	public List<MonsterHunt> getAllMonsterHunts();
	public List<LootReceived> getLootReceivedByMonsterHunt(int hunt_id);
	public LootReceived getLootReceived(int loot_received_id);
	public List<LootReceived> getLootReceivedByMonsterType(String monster_type);
	
	public void updateMonsterHunt(MonsterHunt hunt);
	public void updateLootReceived(LootReceived loot_received);
	
	public void deleteMonsterHunt(int hunt_id);
	public void deleteLootReceived(int loot_received_id);
	
}
