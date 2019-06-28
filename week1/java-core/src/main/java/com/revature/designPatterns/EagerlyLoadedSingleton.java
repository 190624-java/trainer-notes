package com.revature.designPatterns;

public class EagerlyLoadedSingleton {
	private static final EagerlyLoadedSingleton INSTANCE =
			new EagerlyLoadedSingleton();
	
	private EagerlyLoadedSingleton() {}
	
	public static EagerlyLoadedSingleton getInstance() {
		return INSTANCE;
	}
	
}
