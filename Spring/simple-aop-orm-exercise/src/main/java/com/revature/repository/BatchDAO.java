package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Batch;
import com.revature.beans.User;

@Repository
public class BatchDAO {

	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void saveBatch(Batch batch) {
		sf.getCurrentSession().save(batch);
	}
	
	@Transactional
	public Batch getBatchById(int id) {
		return (Batch) sf.getCurrentSession().get(Batch.class, id);
	}
	
	@Transactional
	public List<Batch> getBatchesByTrainer(User user){
		return sf.getCurrentSession().createCriteria(Batch.class).add(Restrictions.eq("batchTrainer", user.getUserId())).list();
	}
	
	@Transactional
	public List<Batch> getBatchesByTrainer(String trainerName){
		return sf.getCurrentSession().createCriteria(Batch.class).createAlias("batchTrainer","t").add(Restrictions.eq("t.user_full_name", trainerName)).list();
	}
	
	@Transactional
	public List<Batch> getAllBatches(){
		return sf.getCurrentSession().createCriteria(Batch.class).list();
	}
	
	@Transactional
	public void deleteBatch(Batch batch) {
		sf.getCurrentSession().delete(batch);
	}
	
}
