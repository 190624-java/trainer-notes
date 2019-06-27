package com.revature.threads;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockSolution {

	public static void main(String[] args) {
		Scientist phil = new Scientist();
		
		new Thread(()->{
			try {
				phil.hypothesize();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				phil.hypothsphorate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}

}

class Scientist {
	
	private ReentrantLock chicken = new ReentrantLock();
	private ReentrantLock egg = new ReentrantLock();
	
	public boolean lock() {
		boolean testingLocks = true;
		while(testingLocks) {
			if(chicken.tryLock() && egg.tryLock()) {
				testingLocks = false;
			}
		}
		return true;
	}
	
	public void unlock() {
		chicken.unlock();
		egg.unlock();
	}
	
	public void hypothesize() throws InterruptedException {
		lock();
		System.out.print("Chicken came before the...");
		Thread.sleep(2000);
		System.out.println("Egg");
		unlock();
	}
	
	public void hypothsphorate() throws InterruptedException {
		lock();
		System.out.print("Egg came before the...");
		Thread.sleep(2000);
		System.out.println("Chicken");
		unlock();
	}
	
}