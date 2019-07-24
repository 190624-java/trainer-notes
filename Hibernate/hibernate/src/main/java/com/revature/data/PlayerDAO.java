package com.revature.data;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Player;

public class PlayerDAO {

	public void save(Player player) {
		//1. Create a session.
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//2. Start a transaction.
		Transaction tx = session.beginTransaction();
		
		//3. Save the player obj to the database.
		Object id = session.save(player);
		System.out.println(id.toString());
		
		//4. Commit the transaction.
		tx.commit();
	}
	
	public Player findPlayer(int id) {
		//1. Create a session.
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//2. retrieve the player
		/*
		 * Two ways to get a row from the db:
		 * (1) Load
		 * 		- returns a proxy to the object.
		 * 			- doesn't run the query until you go to use the object
		 * 		- if the object is not found in the db, it throws a 
		 * 	ObjectNotfoundException.
		 * 		- use it when you know the object is in the database.
		 * 
		 * (2) Get
		 * 		- returns the object directly.
		 * 		- if the object is not found, it returns null.
		 */
		//(1) Load
		//return (Player) session.load(Player.class, id);
		
		//(2) Get
		return (Player) session.get(Player.class, id);
	}
	
	//findByUsername uses HQL to query the db.
	public Player findByUsername(String username) {
		//1. Create a session.
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//2. Write the hql String
		// select * is implied if you don't specify a select clause
		String hql = "FROM com.revature.beans.Player WHERE username = :user";
		Query query = session.createQuery(hql);
		query.setString("user", username);
		
		//3. Get the results.
		//if the query returns more than one result, use query.list();
		//otherwise, use query.uniqueResult();
		return (Player) query.uniqueResult();
	}
	
	//findInLevelRange uses the Criteria API
	public List<Player> findInLevelRange(int low, int high){
		//1. Create a session.
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		/*
		 * //2. Construct a criteria object representing the query. Criteria criteria =
		 * session.createCriteria(Player.class);
		 * 
		 * //3. Add Restrictions (like WHERE clauses) or Projections (like agg fxns)
		 * criteria.add(Restrictions.between("playerLevel", low, high));
		 * 
		 * //4. Execute the query. return criteria.list();
		 */
		
		//2.-4. in one line
		return session.createCriteria(Player.class)
				.add(Restrictions.between("playerLevel", low, high))
				.list();
		
	}
	
	public Integer findHighestLevel() {
		return (Integer) HibernateUtils.getSessionFactory().openSession()
				.createCriteria(Player.class)
				.setProjection(Projections.max("playerLevel")).uniqueResult();
	}
	
	//findLowestLevel uses native SQL
	public BigDecimal findLowestLevel() {
		String nativeSQLString = "SELECT MIN(player_level) FROM player";
		SQLQuery query = HibernateUtils.getSessionFactory().openSession()
				.createSQLQuery(nativeSQLString);
		//query.addEntity(Player.class);//need this when returning objects of type Player
		return (BigDecimal) query.uniqueResult();
	}
	
}
