package com.revature.dbDAOimpls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static final String url = "jdbc:oracle:thin:"
			+ "@jcol-sql-demo-db.chueiwozbnfz.us-east-1.rds.amazonaws.com"
			+ ":1521:ORCL";
	// jdbc:oracle:thin:@hostname:1521:sid
	private static final String username = "jcol190624";
	private static final String password = "MyDBPass123$";
	
	public static Connection getConnection() throws SQLException {
		//THIS WILL BE ON THE TEST AND IN CLIENT INTERVIEWS
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnectionUsingProp() throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties"));
		return DriverManager.getConnection(url, prop);
	}
}
