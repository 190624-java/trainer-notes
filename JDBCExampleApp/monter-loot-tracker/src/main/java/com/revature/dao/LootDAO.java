package com.revature.dao;

import com.revature.beans.*;
import java.util.List;

public interface LootDAO {

	public Loot createLoot(Loot loot);
	public LootType createLootType(LootType loot_type);
	
	public Loot getLoot(int loot_id);
	public List<Loot> getLootByType(String loot_type);
	public List<Loot> getLootByType(int loot_type_id);
	public List<Loot> getLoot(String loot_name);
	public LootType getLootType(int loot_type_id);
	public List<LootType> getAllLootTypes();
	public List<Loot> getAllLoot();
	
	public void updateLootType(LootType loot_type);
	public void updateLoot(Loot loot);
	
	public void deleteLootType(int loot_type_id);
	public void deleteLoot(int loot_id);
	
}
