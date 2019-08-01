package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Associate;
import com.revature.beans.Batch;

@Repository
public class AssociateDAO {

	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void saveAssociate(Associate associate) {
		sf.getCurrentSession().save(associate);
	}
	
	@Transactional
	public Associate getAssociateById(int id) {
		return (Associate) sf.getCurrentSession().get(Associate.class, id);
	}
	
	@Transactional
	public Associate getAssociateByName(String name) {
		return (Associate) sf.getCurrentSession().createCriteria(Associate.class).add(Restrictions.eq("associateName", name)).list();
	}
	
	@Transactional
	public List<Associate> getAssociatesByBatch(Batch batch){
		return sf.getCurrentSession().createCriteria(Associate.class)
				.createAlias("associateBatch", "batch")
				.add(Restrictions.eq("batch.batchId", batch.getBatchId()))
				.list();
	}
	
	@Transactional
	public List<Associate> getAllAssociates(){
		return sf.getCurrentSession().createCriteria(Associate.class).list();
	}
	
	@Transactional
	public void deleteAssociate(Associate a) {
		sf.getCurrentSession().delete(a);
	}
	
}
