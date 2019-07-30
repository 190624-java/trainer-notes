package com.revature.spring.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //handles web requests (IS NOT A SERVLET)
public class SpringController {

	@Autowired
	private SpringService service;
	
	public SpringService getService() {
		return service;
	}
	
}
