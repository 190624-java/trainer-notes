package com.revature.designPatterns.dao;
/*
 * DAO - data access object, only perform CRUD operations
 * CRUD - create, read, update, delete
 */

import java.util.List;

public interface UserDAO {
	public User findById(int id);
	public List<User> findAll();
	public User save(User user);
	//etc. any methods that interact with the data
}
