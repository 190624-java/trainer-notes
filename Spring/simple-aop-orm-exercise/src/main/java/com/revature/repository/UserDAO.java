package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void save(User user) {
		sf.getCurrentSession().save(user);
	}
	
	@Transactional
	public User getUserById(int id) {
		return (User) sf.getCurrentSession().get(User.class, id);
	}
	
	@Transactional
	public List<User> getAllUsers(){
		return sf.getCurrentSession().createCriteria(User.class).list();
	}
	
	@Transactional
	public void deleteUser(User user) {
		sf.getCurrentSession().delete(user);
	}
	
}
