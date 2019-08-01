package com.revature.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.revature.aop.service.Building;
import com.revature.aop.service.HeroService;

@Configuration
@ComponentScan(basePackages= "com.revature.aop")
@EnableAspectJAutoProxy //using annotation config for AOP
public class AOPApplication {

	public static void main(String[] args) {
		//helloAOP();
		lotsOPointcuts();
	}
	
	public static void lotsOPointcuts() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AOPApplication.class);
		HeroService service = (HeroService)context.getBean(HeroService.class);
		/*
		 * System.out.println("\t\t --- getHeroCount()");
		 * System.out.println(service.getHeroCount());
		 * System.out.println("\t\t --- getHeroes()");
		 * System.out.println(service.getHeroes());
		 * System.out.println("\t\t --- getPaladins()");
		 * System.out.println(service.getPaladins());
		 * System.out.println("\t\t --- getHeroCount(\"mages\")");
		 * System.out.println(service.getHeroCount("mages"));
		 */
//		System.out.println("\t\t --- search()");
//		System.out.println(service.search());
		System.out.println("\t\t --- findOne(\"Rose Knight\")");
		System.out.println(service.findOne("Rose Knight"));
	}
	
	public static void helloAOP() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AOPApplication.class);
		Building b = (Building) context.getBean(Building.class);
		b.enter();
		b.exit();
	}

}
