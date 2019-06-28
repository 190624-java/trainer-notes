package com.revature.designPatterns.dao;

import java.util.List;

/*
 * service classes have business logic.
 * going to call the DAO implementation class to get the data it needs
 */
public class DAOServiceClass {

	UserDAO dao = new FileSystemUserDAOImpl();
	
	public void doStuff() {
		dao.save(new User("Dan"));
		List<User> users = dao.findAll();
	}
}
