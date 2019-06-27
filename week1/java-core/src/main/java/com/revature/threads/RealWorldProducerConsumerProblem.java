package com.revature.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class RealWorldProducerConsumerProblem {

	static ArrayBlockingQueue<Integer> inventory = 
			new ArrayBlockingQueue<>(20);
	static Random rand = new Random();
	
	public static void main(String[] args) {
		//producer
		new Thread(()->{
			for(;;) {
				try {
					inventory.put(rand.nextInt(1_000));
					System.out.println(inventory.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		//consumer
		new Thread(()->{
			for(;;) {
				try {
					inventory.take();
					System.out.println(inventory.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
