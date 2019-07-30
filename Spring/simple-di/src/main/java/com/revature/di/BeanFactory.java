package com.revature.di;

/**
 * Only one BeanFactory per app. Register your beans here,
 * and then we let it propagate those beans where they are 
 * needed throughout the whole app.
 * 
 * @author Revature
 *
 */

public class BeanFactory {

//	public static Engine getEngine() {
//		return new ElectricEngine();
//	}
	
	public static Object getBean(String beanName) {
		if(beanName.equals("engine")) {
			return new ElectricEngine();
		} else {
			return null;
		}
	}
	
}
