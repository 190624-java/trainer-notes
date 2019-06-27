package com.revature.threads;

import java.util.LinkedList;
import java.util.Random;

public class ProduceAndConsume {
	private LinkedList<Integer> list = new LinkedList<>();
	//list represents inventory
	
	//limit the memory usage of this list
	private final int BUFFER = 20;
	
	Random rand = new Random();
	
	private volatile boolean full = false;
	/*
	 * marking a variable as volatile, prevents
	 * it from being cached in thread-local memory.
	 * 
	 * if an object is likely to be re-referenced,
	 * mark it as volatile to ensure thread-safety
	 */
	
	//you don't have to (nor should you) sync on 'this'
	private Object lock = new Object();
	
	public void produce() throws Exception {
		synchronized(lock){
			for(;;) {
				while(full) {
					lock.wait();
				}
				System.out.println(list.size());
				list.add(rand.nextInt(1_000));
				lock.notify();
				this.full = !(list.size() < BUFFER);
			}
		}
	}
	
	public void consume() throws Exception {
		synchronized(lock) {
			for(;;) {
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.println(list.size());
				list.removeFirst();
				lock.notify();
				this.full = list.size() < BUFFER ? false : true;
			}
		}
	}
}
