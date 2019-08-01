package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Player;
import com.revature.repository.PlayerDAO;
import com.revature.repository.PlayerDAOImpl;

@Service
public class PlayerService {

	@Autowired
	private PlayerDAOImpl dao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveMultiple(List<Player> players) {
		for(Player player : players) {
			//if any one save call fails, we want them all to rollback
			dao.save(player);
		}
	}
	
	//no transaction is created.
	public void save(Player player) {
		dao.save(player);
	}
	
}
