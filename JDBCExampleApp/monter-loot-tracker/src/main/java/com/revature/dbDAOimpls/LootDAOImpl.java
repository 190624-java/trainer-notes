package com.revature.dbDAOimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Loot;
import com.revature.beans.LootType;
import com.revature.dao.LootDAO;

public class LootDAOImpl implements LootDAO {

	@Override
	public Loot createLoot(Loot loot) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO Loot(loot_type_id, loot_name, loot_size)"
					+ " VALUES (?,?,?)";
			String[] primaryKeys = {"loot_id"};
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setInt(1, loot.getLoot_type().getLoot_type_id());
			stmnt.setString(2, loot.getLoot_name());
			stmnt.setInt(3, loot.getLoot_size());
			
			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while(rs.next()) {
				loot.setLoot_id(rs.getInt(1));
			}
			return loot;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LootType createLootType(LootType loot_type) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT LootType(loot_type_name)"
					+ " VALUES (?)";
			String[] primaryKeys = {"loot_type_id"};
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setString(1, loot_type.getLoot_type());
			
			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while(rs.next()) {
				loot_type.setLoot_type_id(rs.getInt(1));
			}
			return loot_type;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Loot getLoot(int loot_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_id, loot_type_id, loot_name, loot_quantity"
					+ " FROM Loot"
					+ " WHERE loot_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot_id);
			ResultSet rs = stmnt.executeQuery();
			Loot loot = null;
			while(rs.next()) {
				int lootTypeId = rs.getInt("loot_type_id");
				LootType lt = getLootType(lootTypeId);
				loot = new Loot(rs.getInt("loot_id"), lt, rs.getString("loot_name"), rs.getInt("loot_quantity"));
			}
			return loot;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Loot> getLootByType(String loot_type) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_id, loot_type_id, loot_name, loot_quantity"
					+ " FROM Loot"
					+ " WHERE loot_type_id = ("
					+ "	SELECT loot_type_id FROM LootType"
					+ " WHERE loot_type_name = ?)";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, loot_type);
			ResultSet rs = stmnt.executeQuery();
			List<Loot> lootList = new ArrayList<Loot>();
			while(rs.next()) {
				int lootTypeId = rs.getInt("loot_type_id");
				LootType lt = getLootType(lootTypeId);
				lootList.add(new Loot(rs.getInt("loot_id"), lt, rs.getString("loot_name"), rs.getInt("loot_quantity")));
			}
			return lootList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Loot> getLootByType(int loot_type_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_id, loot_type_id, loot_name, loot_quantity"
					+ " FROM Loot"
					+ " WHERE loot_type_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot_type_id);
			ResultSet rs = stmnt.executeQuery();
			List<Loot> lootList = new ArrayList<Loot>();
			while(rs.next()) {
				int lootTypeId = rs.getInt("loot_type_id");
				LootType lt = getLootType(lootTypeId);
				lootList.add(new Loot(rs.getInt("loot_id"), lt, rs.getString("loot_name"), rs.getInt("loot_quantity")));
			}
			return lootList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Loot> getLoot(String loot_name) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_id, loot_type_id, loot_name, loot_quantity"
					+ " FROM Loot"
					+ " WHERE loot_name = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, loot_name);
			ResultSet rs = stmnt.executeQuery();
			List<Loot> lootList = new ArrayList<Loot>();
			while(rs.next()) {
				int lootTypeId = rs.getInt("loot_type_id");
				LootType lt = getLootType(lootTypeId);
				lootList.add(new Loot(rs.getInt("loot_id"), lt, rs.getString("loot_name"), rs.getInt("loot_quantity")));
			}
			return lootList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LootType getLootType(int loot_type_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_type_id, loot_type_name"
					+ " FROM LootType"
					+ " WHERE loot_type_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot_type_id);
			ResultSet rs = stmnt.executeQuery();
			LootType lootType = null;
			while(rs.next()) {
				lootType = new LootType(rs.getInt("loot_type_id"), rs.getString("loot_type_name"));
			}
			return lootType;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LootType> getAllLootTypes() {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_type_id, loot_type_name"
					+ " FROM LootType";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			
			ResultSet rs = stmnt.executeQuery();
			List<LootType> lootList = new ArrayList<LootType>();
			while(rs.next()) {
				lootList.add(new LootType(rs.getInt("loot_type_id"), rs.getString("loot_type_name")));
			}
			return lootList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Loot> getAllLoot() {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT loot_id, loot_type_id, loot_name, loot_quantity"
					+ " FROM Loot";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			
			ResultSet rs = stmnt.executeQuery();
			List<Loot> lootList = new ArrayList<Loot>();
			while(rs.next()) {
				int lootTypeId = rs.getInt("loot_type_id");
				LootType lt = getLootType(lootTypeId);
				lootList.add(new Loot(rs.getInt("loot_id"), lt, rs.getString("loot_name"), rs.getInt("loot_quantity")));
			}
			return lootList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateLootType(LootType loot_type) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE LootType"
					+ " SET loot_type_name = ?"
					+ " WHERE loot_type_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, loot_type.getLoot_type());
			stmnt.setInt(2, loot_type.getLoot_type_id());
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLoot(Loot loot) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE Loot"
					+ " SET loot_type_id = ?, loot_name = ?, loot_size = ?"
					+ " WHERE loot_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot.getLoot_type().getLoot_type_id());
			stmnt.setString(2, loot.getLoot_name());
			stmnt.setInt(3, loot.getLoot_size());
			stmnt.setInt(4, loot.getLoot_id());
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLootType(int loot_type_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM LootType"
					+ " WHERE loot_type_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot_type_id);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLoot(int loot_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM Loot"
					+ " WHERE loot_id = ?";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, loot_id);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
