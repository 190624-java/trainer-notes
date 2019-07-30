package com.revature.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.vehicle.Car;

public class LifecycleDriver {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		MyLifecycleBean bean = (MyLifecycleBean) context.getBean(MyLifecycleBean.class);
		bean.go();
		
		Car car = (Car) context.getBean(Car.class);
		Car car2 = (Car) context.getBean(Car.class);
		
		context.close();
	}

}
