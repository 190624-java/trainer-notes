package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Player;

@Repository
public class PlayerDAOImpl {

	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Transactional 
	public List<Player> findAll() {
		//once per thread, the tx manager will bind a Session to the thread
		//so, don't use sf.openSession();
		return sf.getCurrentSession().createCriteria(Player.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,
			rollbackFor = Exception.class)
	public void save(Player player) {
		sf.getCurrentSession().save(player);
	}

}
