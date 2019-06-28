package com.revature.designPatterns;

public class DesignPatternDriver {

	public static void main(String[] args) {
//		new Thread(()->{
//			EagerlyLoadedSingleton obj = EagerlyLoadedSingleton.getInstance();
//			System.out.println("Thread 1: " + obj);
//		}).start();
//		new Thread(()->{
//			EagerlyLoadedSingleton obj = EagerlyLoadedSingleton.getInstance();
//			System.out.println("Thread 2: " + obj);
//		}).start();
		
		new Thread(()->{
			LazyLoadedSingleton obj = LazyLoadedSingleton.getInstance();
			System.out.println("Thread 1: " + obj);
		}).start();
		new Thread(()->{
			LazyLoadedSingleton obj = LazyLoadedSingleton.getInstance();
			System.out.println("Thread 2: " + obj);
		}).start();

	}

}
