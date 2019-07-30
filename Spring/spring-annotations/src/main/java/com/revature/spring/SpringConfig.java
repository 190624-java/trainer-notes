package com.revature.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public DAO dao() {
		return new DAO();
	}
	
	@Bean
	public Service service(DAO dao) {
		//constructor injection
		return new Service(dao);
		
		/*//setter injection
		 * Service service = new Service();
		 * service.setDAO(dao);
		 * return service;
		 */
	}
	
	@Bean
	public Controller controller() {
		return new Controller();
	}
}
