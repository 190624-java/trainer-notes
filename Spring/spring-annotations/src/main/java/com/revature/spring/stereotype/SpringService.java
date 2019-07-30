package com.revature.spring.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //core business logic
public class SpringService {

	@Autowired
	private SpringDAO dao;
	
	@Autowired
	private FacebookAPIObject fbObject;
	
}
