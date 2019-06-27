package com.revature.threads;

public class BasicThreads {

	public static void main(String[] args) {
		Thread t1 = new Thread(new SimpleProcessExecution());
		System.out.println(t1.getState());
		t1.setName("simple thread");
		
		t1.start();
		while(t1.isAlive()) {
			System.out.println(t1.getState());
		}
		
		System.out.println(t1.getState());

		/*anonymous inner classes
		 *  can be passed as an argument to a method.
		 */
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("I am the process.");
			}
		});
		
		/*
		 * Functional Programming
		 * 
		 * - lambda functions are an example of functional programming
		 * 		- when you use -> to represent anonymous inner classes
		 * 		- this only works with functional interfaces
		 * 		- when the method you are passing it to, only takes a specific type
		 */
		
		new Thread(()->{
			System.out.println("Hello World, I am in a thread!");
		}).start();
		
	}//ends main
	
}//ends basicThreads

class SimpleProcessExecution implements Runnable {

	@Override
	public void run() {
		//this is where we put our execution code
		System.out.println("What is the process?");
	}
	
}