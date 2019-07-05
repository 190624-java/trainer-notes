package com.revature.dbDAOimpls;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Monster;
import com.revature.dao.MonsterDAO;

public class MonsterDAOImpl implements MonsterDAO {

	@Override
	public Monster createMonster(Monster monster) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO Monster(monster_type, monster_level)"
					+ " VALUES (?,?)";
			String[] primaryKeys = {"monster_id"};
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setString(1, monster.getMonster_type());
			stmnt.setInt(2, monster.getMonster_level());
			
			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while(rs.next()) {
				monster.setMonster_id(rs.getInt(1));
			}
			return monster;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Monster getMonster(int monster_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT monster_id, monster_type, monster_level "
					+ "FROM Monster "
					+ "WHERE monster_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, monster_id);
			ResultSet monsters = stmnt.executeQuery();
			Monster monster = null;
			while(monsters.next()) {
				monster = new Monster(monsters.getInt("monster_id"),
						monsters.getString("monster_type"), 
						monsters.getInt("monster_level"));
			}
			return monster;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Monster getMonster(String monster_name, int monster_level) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT monster_id, monster_type, monster_level "
					+ "FROM Monster "
					+ "WHERE monster_type = ? AND monster_level = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, monster_name);
			stmnt.setInt(2, monster_level);
			ResultSet rs = stmnt.executeQuery();
			List<Monster> monsters = new ArrayList<>();
			while(rs.next()) {
				monsters.add(new Monster(rs.getInt("monster_id"),
						rs.getString("monster_type"), 
						rs.getInt("monster_level")));
			}
			if(monsters.size() > 1) {
				System.out.println("More than one monster was returned!");
				return null;
			} else if (monsters.size() == 0) {
				System.out.println("No monsters were returned!");
				return null;
			} else if (monsters.size() == 1) {
				return monsters.get(0);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Monster> getAllMonsters() {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT monster_id, monster_type, monster_level "
					+ "FROM Monster";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			List<Monster> monsters = new ArrayList<>();
			while(rs.next()) {
				monsters.add(new Monster(rs.getInt("monster_id"),
						rs.getString("monster_type"), 
						rs.getInt("monster_level")));
			}
			return monsters;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateMonster(Monster monster) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE Monster"
					+ " SET monster_type = ?, monster_level = ?"
					+ " WHERE monster_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, monster.getMonster_type());
			stmnt.setInt(2, monster.getMonster_level());
			stmnt.setInt(3,  monster.getMonster_id());
			
			int rowsUpdated = stmnt.executeUpdate();
			System.out.println("Number of monsters updated: " + rowsUpdated);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMonster(Monster monster) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE Monster"
					+ " WHERE monster_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,  monster.getMonster_id());
			
			int rowsDeleted = stmnt.executeUpdate();
			System.out.println("Number of monsters deleted: " + rowsDeleted);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
