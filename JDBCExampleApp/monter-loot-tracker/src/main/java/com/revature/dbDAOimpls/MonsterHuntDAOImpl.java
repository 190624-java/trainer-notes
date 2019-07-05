package com.revature.dbDAOimpls;

import java.util.List;

import com.revature.beans.LootReceived;
import com.revature.beans.Monster;
import com.revature.beans.MonsterHunt;
import com.revature.beans.Player;
import com.revature.dao.MonsterHuntDAO;

public class MonsterHuntDAOImpl implements MonsterHuntDAO {

	@Override
	public MonsterHunt createMonsterHunt(MonsterHunt hunt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LootReceived createLootReceived(LootReceived loot_received) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonsterHunt getMonsterHunt(int hunt_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonsterHunt> getMonsterHuntsByMonster(Monster monster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonsterHunt> getMonsterHuntsByPlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonsterHunt> getAllMonsterHunts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LootReceived> getLootReceivedByMonsterHunt(int hunt_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LootReceived getLootReceived(int loot_received_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LootReceived> getLootReceivedByMonsterType(String monster_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMonsterHunt(MonsterHunt hunt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLootReceived(LootReceived loot_received) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMonsterHunt(int hunt_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLootReceived(int loot_received_id) {
		// TODO Auto-generated method stub

	}

}
