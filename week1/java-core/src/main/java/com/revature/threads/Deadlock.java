package com.revature.threads;

public class Deadlock {

	public static void main(String[] args) {
		Philosopher phil = new Philosopher();
		
		new Thread(()->{
			try {
				phil.philosophize();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				phil.philosphorate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}

class Philosopher {
	//these are locks
	private Object chicken = new Object();
	private Object egg = new Object();
	
	public void philosophize() throws InterruptedException {
		//get a lock on that chicken
		synchronized(chicken) {
			System.out.print("The Chicken came before the ... ");
			Thread.sleep(2000);
			//get a lock on that egg
			synchronized(egg) {
				System.out.println("Egg");
			}
		}
	}
	
	public void philosphorate() throws InterruptedException {
		//get a lock on that egg
		synchronized(egg) {
			System.out.print("The Egg came before the ... ");
			Thread.sleep(2000);
			//get a lock on that chicken
			synchronized(chicken) {
				System.out.println("Chicken");
			}
		}
	}
}


