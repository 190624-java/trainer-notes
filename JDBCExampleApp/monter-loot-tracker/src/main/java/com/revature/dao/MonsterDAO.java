package com.revature.dao;

import java.util.List;

import com.revature.beans.*;

public interface MonsterDAO {

	public Monster createMonster(Monster monster);
	
	public Monster getMonster(int monster_id);
	public Monster getMonster(String monster_name, int monster_level);
	public List<Monster> getAllMonsters();
	
	public void updateMonster(Monster monster);
	
	public void deleteMonster(Monster monster);
	
}
