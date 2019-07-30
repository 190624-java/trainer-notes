package com.revature.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

	@Autowired
	private Service service;
	
	/*
	 * Spring will automagically inject the bean.
	 * no setter or constructor injection necessary
	 * 
	 * byType, byName, auto..
	 * 
	 * uses inflection to set the property
	 */

	public Service getService() {
		return service;
	}
	
}
