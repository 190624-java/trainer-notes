package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.beans.User;
import com.revature.repository.BatchDAO;

@Service
public class BatchService {

	@Autowired
	private BatchDAO dao;
	
	public void getBatches() {
		System.out.println(dao.getAllBatches());
	}
	
	public void createBatch(Batch b) {
		dao.saveBatch(b);
	}
	
}
