package com.revature.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	/*
	 * We are going to make SessionFactory a singleton,
	 * because it is very heavy-weight, and we don't need/want
	 * to instantiate it more than once.
	 */
	private static SessionFactory sessionFactory;
	
	static {
		// 1. Use the Configuration object to store the 
		//	hibernate.cfg.xml properties
		Configuration config = new Configuration()
				.configure(HibernateUtils.class.getResource("/hibernate.cfg.xml"));
		
		// 2.a. Create a ServiceRegistryBuilder to build ServiceRegistry
		StandardServiceRegistryBuilder serviceRegBuilder = new StandardServiceRegistryBuilder();
		// 2.b. Apply the Hibernate configuration to our SRB.
		serviceRegBuilder.applySettings(config.getProperties());
		// 2.c. Build the ServiceRegistry
		ServiceRegistry serviceReg = serviceRegBuilder.build();
		
		// 3. use Configuration to build the SessionFactory and
		// register it to the ServiceRegistry
		sessionFactory = config.buildSessionFactory(serviceReg);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
