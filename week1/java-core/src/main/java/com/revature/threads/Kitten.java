package com.revature.threads;

public class Kitten {

	public void waitForFood() throws InterruptedException {
		synchronized(this) {
			System.out.println("Waiting...");
			//tells 'this' to wait until notified.
			this.wait();// the lock on 'this' is released
			
			System.out.println("Done waiting. Was fed.");
		}
	}
	
	public void feed() throws InterruptedException {
		synchronized(this) {
			//notify the most recent thread that had the lock
			this.notify();
			System.out.println("Fed (Notified)");
			// notify() doesn't release the lock until this 
			//block finishes
			//Thread.sleep(2000);
		}
	}
	
	public void nap() {
		System.out.print("\nSleeping");
		for(;;) {
			try {
				System.out.print(".");
				Thread.sleep(2000);
				// sleep holds onto the object's monitor if it has one,
				//unlike wait.
			} catch (InterruptedException e) {
				//handling exception, breaking infinite loop
				break;
			}
		}
		System.out.println("Thread Awake!");
	}
	
}
