package com.revature.threads;

public class ProdConsumeDriver {

	public static void main(String[] args) {
		ProduceAndConsume pac = new ProduceAndConsume();
		//The problem
		Thread producer = new Thread(()->{
			try {
				pac.produce();
			} catch (Exception e) {
				System.out.println("Broken!");
			}
		});
		Thread consumer = new Thread(()->{
			try {
				pac.consume();
			} catch (Exception e) {
				System.out.println("Broken!");
			}
		});
		
		producer.start();
		consumer.start();
		

	}

}
