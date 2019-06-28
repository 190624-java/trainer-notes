package com.revature.designPatterns;

public class LazyLoadedSingleton {

	private static LazyLoadedSingleton INSTANCE;
	
	private LazyLoadedSingleton() {}
	
	public static synchronized LazyLoadedSingleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LazyLoadedSingleton();
		}
		return INSTANCE;
	}
	
}
