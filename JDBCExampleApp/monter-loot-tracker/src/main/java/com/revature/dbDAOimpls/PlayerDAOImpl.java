package com.revature.dbDAOimpls;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Player;
import com.revature.dao.PlayerDAO;

/*
 * PreparedStatement
 * 	- pre-compiled
 *  - more efficient
 *  - safer against SQL injections
 */

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public Player createPlayer(Player player) {
		// 1. get a connection to the database
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. Create a statement
			String sql = "INSERT INTO Player(username, player_level)" + "VALUES (?,?)";
			String[] primaryKeyValues = { "player_id" };
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			stmt.setString(1, player.getUsername());
			stmt.setInt(2, player.getPlayer_level());

			// 3. Executing the statement
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows Inserted: " + rowsAffected);

			// 4. get player_id
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int playerId = keys.getInt(1);
				player.setPlayer_id(playerId);
			}
			return player;
		} catch (SQLException e) {
			// would probably want to throw a custom application-specific
			// exception to be handled elsewhere
			System.out.println("Something went wrong while trying to create a player in the databsae.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Player getPlayer(int player_id) {
		// 1. get a connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// 2. create a statement
			Statement stmt = conn.createStatement();
			String sql = "SELECT player_id, username, player_level" + "FROM Player" + "WHERE player_id = " + player_id;

			// 3. execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);

			// 4. iterate through results and map to object
			Player player = null;
			while (results.next()) {
				int playerId = results.getInt("player_id");
				String username = results.getString(2);
				int playerLevel = results.getInt("player_level");
				player = new Player(playerId, username, playerLevel);
			}
			return player;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Player getPlayer(String username) {
		// 1. get a connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. create a statement
			String sql = "SELECT player_id, username, player_level" + "FROM Player" + "WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			// 3. execute query
			ResultSet results = stmt.executeQuery();
			System.out.println(results);

			// 4. iterate through results and map to object
			Player player = null;
			while (results.next()) {
				int playerId = results.getInt("player_id");
				String uname = results.getString(2);
				int playerLevel = results.getInt("player_level");
				player = new Player(playerId, uname, playerLevel);
			}
			return player;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong while trying to return a player from the database.");
			return null;
		}
	}

	@Override
	public int getPlayerLevel(String username) {
		// this example is to show how we can call stored procedures
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. create statement
			String sql = "{call get_player_level(?,?)}";
			int level = 0;
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, username);

			// 3. register out parameters (if any)
			stmt.registerOutParameter(2, Types.INTEGER);

			// 4. execute the stored procedure
			stmt.execute();

			// 5. retrieve out params (if any)
			level = stmt.getInt(2);
			return level;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Player> getAllPlayers() {
		// 1. get a connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. create a statement
			String sql = "SELECT player_id, username, player_level" 
			+ "FROM Player";
			PreparedStatement stmt = conn.prepareStatement(sql);

			// 3. execute query
			ResultSet results = stmt.executeQuery();
			System.out.println(results);

			// 4. iterate through results and map to object
			List<Player> players = new ArrayList<>();
			while (results.next()) {
				int playerId = results.getInt("player_id");
				String uname = results.getString(2);
				int playerLevel = results.getInt("player_level");
				Player player = new Player(playerId, uname, playerLevel);
				players.add(player);
			}
			return players;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong while trying to return a player from the database.");
			return null;
		}
	}

	@Override
	public void updatePlayer(Player player) {
		// 1. get connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. Create statement
			String sql = "UPDATE Player " + "SET username = ?, player_level = ? " + "WHERE player_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, player.getUsername());
			stmt.setInt(2, player.getPlayer_level());
			stmt.setInt(3, player.getPlayer_id());

			// 3. execute the update
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Number of Players Updated: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePlayer(Player player) {
		// 1. get connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// 2. Create statement
			String sql = "DELETE FROM Player " + "WHERE player_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, player.getPlayer_id());

			// 3. execute the delete
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Number of Players Deleted: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
