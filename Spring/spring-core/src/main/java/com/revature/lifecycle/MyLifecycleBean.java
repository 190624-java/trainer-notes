package com.revature.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.revature.vehicle.Car;

public class MyLifecycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String prop;
	private String beanName;
	private BeanFactory beanFactory;
	private ApplicationContext context;
	
	public MyLifecycleBean() {
		System.out.println("Bean Instantiated.");
	}
	
	public void setProp(String prop) {
		this.prop = prop;
		System.out.println("Populate Properties: " + prop);
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("BeanNameAware: " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware: " + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		System.out.println("ApplicationContextAware: " + context);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet");
	}
	
	public void customInit() {
		System.out.println("Custom init()");
	}
	
	public void go() {
		System.out.println("Bean is in-use!");
		/*
		 * ApplicationContextAware is useful for getting instances of Prototype beans
		 */
		Car gimmeCarPlease = (Car) context.getBean(Car.class);
		gimmeCarPlease.start();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean's destroy()");
	}
	
	public void myDestroy() {
		System.out.println("Custom destroy()");
	}
	
}
