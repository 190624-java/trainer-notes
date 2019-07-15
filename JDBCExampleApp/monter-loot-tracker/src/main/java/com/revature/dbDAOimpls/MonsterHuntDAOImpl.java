package com.revature.dbDAOimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.LootReceived;
import com.revature.beans.Monster;
import com.revature.beans.MonsterHunt;
import com.revature.beans.Player;
import com.revature.dao.MonsterHuntDAO;

public class MonsterHuntDAOImpl implements MonsterHuntDAO {

	@Override
	public MonsterHunt createMonsterHunt(MonsterHunt hunt) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO MonsterHunt(monster_id, player_id, attack_multiplier)"
					+ " VALUES (?,?,?)";
			String[] primaryKeys = {"monster_hunt_id"};
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setInt(1, hunt.getMonster().getMonster_id());
			stmnt.setInt(2, hunt.getPlayer().getPlayer_id());
			stmnt.setInt(3, hunt.getAttack_multiplier());
			
			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while(rs.next()) {
				hunt.setMonster_hunt_id(rs.getInt(1));
			}
			return hunt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LootReceived createLootReceived(LootReceived loot_received) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO LootReceived(loot_id, monster_hunt_id, quantity_received)"
					+ " VALUES (?,?,?)";
			String[] primaryKeys = {"loot_received_id"};
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setInt(1, loot_received.getLoot().getLoot_id());
			stmnt.setInt(2, loot_received.getMonster_hunt().getMonster_hunt_id());
			stmnt.setInt(3, loot_received.getQuantity_received());
			
			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while(rs.next()) {
				loot_received.setLoot_received_id(rs.getInt(1));
			}
			return loot_received;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MonsterHunt getMonsterHunt(int hunt_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * "
					+ "FROM MonsterHunt"
					+ "INNER JOIN Player ON Player.player_id = MonsterHunt.player_id"
					+ "INNER JOIN Monster ON Monster.monster_id = MonsterHunt.monster_id "
					+ "WHERE monster_hunt_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, hunt_id);
			ResultSet hunts = stmnt.executeQuery();
			MonsterHunt hunt = null;
			while(hunts.next()) {
				Player p = new Player(hunts.getInt("player_id"),
						hunts.getString("username"),
						hunts.getInt("player_level"));
				Monster m = new Monster(hunts.getInt("monster_id"),
						hunts.getString("monster_type"),
						hunts.getInt("monster_level"));
				hunt = new MonsterHunt(hunts.getInt("monster_hunt_id"),
						m, 
						p,
						hunts.getInt("attack_multiplier"));
			}
			return hunt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MonsterHunt> getMonsterHuntsByMonster(Monster monster) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * "
					+ "FROM MonsterHunt"
					+ "INNER JOIN Player ON Player.player_id = MonsterHunt.player_id "
					+ "WHERE monster_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, monster.getMonster_id());
			ResultSet results = stmnt.executeQuery();
			List<MonsterHunt> hunts = new ArrayList<>();
			while(results.next()) {
				Player p = new Player(results.getInt("player_id"),
						results.getString("username"),
						results.getInt("player_level"));
				hunts.add(new MonsterHunt(results.getInt("monster_hunt_id"),
						monster, 
						p,
						results.getInt("attack_multiplier")));
			}
			return hunts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MonsterHunt> getMonsterHuntsByPlayer(Player player) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * "
					+ "FROM MonsterHunt"
					+ "INNER JOIN Monster ON Monster.monster_id = MonsterHunt.monster_id "
					+ "WHERE player_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, player.getPlayer_id());
			ResultSet results = stmnt.executeQuery();
			List<MonsterHunt> hunts = new ArrayList<>();
			while(results.next()) {
				Monster m = new Monster(results.getInt("monster_id"),
						results.getString("monster_type"),
						results.getInt("monster_level"));
				hunts.add(new MonsterHunt(results.getInt("monster_hunt_id"),
						m, 
						player,
						results.getInt("attack_multiplier")));
			}
			return hunts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MonsterHunt> getAllMonsterHunts() {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * "
					+ "FROM MonsterHunt"
					+ "INNER JOIN Player ON Player.player_id = MonsterHunt.player_id"
					+ "INNER JOIN Monster ON Monster.monster_id = MonsterHunt.monster_id ";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet results = stmnt.executeQuery();
			List<MonsterHunt> hunts = new ArrayList<>();
			while(results.next()) {
				Player p = new Player(results.getInt("player_id"),
						results.getString("username"),
						results.getInt("player_level"));
				Monster m = new Monster(results.getInt("monster_id"),
						results.getString("monster_type"),
						results.getInt("monster_level"));
				hunts.add(new MonsterHunt(results.getInt("monster_hunt_id"),
						m, 
						p,
						results.getInt("attack_multiplier")));
			}
			return hunts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE MonsterHunt"
					+ "SET monster_id = ?,"
					+ " player_id = ?,"
					+ " attack_multiplier = ?"
					+ " WHERE monster_hunt_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, hunt.getMonster().getMonster_id());
			stmnt.setInt(2, hunt.getPlayer().getPlayer_id());
			stmnt.setInt(3, hunt.getAttack_multiplier());
			stmnt.setInt(4, hunt.getMonster_hunt_id());
			
			int rowsUpdated = stmnt.executeUpdate();
			System.out.println("MonsterHunts updated: " + rowsUpdated);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void updateLootReceived(LootReceived loot_received) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMonsterHunt(int hunt_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM MonsterHunt"
					+ " WHERE monster_hunt_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, hunt_id);
			
			int rowsUpdated = stmnt.executeUpdate();
			System.out.println("MonsterHunts deleted: " + rowsUpdated);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}

	@Override
	public void deleteLootReceived(int loot_received_id) {
		// TODO Auto-generated method stub

	}

}
