package com.revature.designPatterns.dao;

import java.io.File;
import java.util.List;

/*
 * This is where we provide implementations for our
 * CRUD methods
 */

public class FileSystemUserDAOImpl implements UserDAO{

	File file = new File("data.csv");
	
	@Override
	public User findById(int id) {
		//use Scanner to find the user by id
		return null;
	}

	@Override
	public List<User> findAll() {
		//read all lines in CSV and return list of users
		return null;
	}

	@Override
	public User save(User user) {
		//add a new entry to the file, generate an id,
		//and return user with updated id field
		return null;
	}

}
