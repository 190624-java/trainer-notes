package com.revature.vehicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		//initialize the Spring Container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//use the context to get instances of our beans
		Car car = (Car) context.getBean("car");//can pass beanName or type
		//Car car = (Car) context.getBean(Car.class);
		car.start();
		
		System.out.println(car);
		Car car2 = (Car) context.getBean("car");
		System.out.println(car2);
	}

	/**
	 * Spring Bean Scopes:
	 * - Singleton - only ever one instance, preinitialized by ApplicationContext.
	 * - Prototype - returns as many instances of an object as you want. They will
	 * 		all be clones based on the structure you provide.
	 * 			   - Not preinitialized by AC
	 * (In webapps only)
	 * - Request - bean only lives as long as the request lives.
	 * - Session - bean only lives as long as the session lives.
	 * 
	 * (In portlet apps only)
	 * - GlobalSession - accessible to all portlets.
	 */
}
