package com.revature.spring.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.revature.spring.stereotype")
public class StereotypeDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StereotypeDriver.class);
		System.out.println(context.getBean(SpringController.class));
	}

}
