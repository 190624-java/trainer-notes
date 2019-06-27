package com.revature.threads;
/*
 * When a method or code block is synchronized,
 * only one thread can effect the object at a time.
 * 
 * we say that when a thread enters a synchronized method
 * it obtains a lock on that object. Meaning no other thread
 * can effect that object.
 * The lock is only released, when the thread completes execution
 * of the synchronized method.
 */

public class Bank {
	public int balance = 0;
	
	public synchronized void withdraw(int amount) {
		this.balance -= amount;
	}
	
	public synchronized void deposit(int amount) {
		this.balance += amount;
	}
	
}
