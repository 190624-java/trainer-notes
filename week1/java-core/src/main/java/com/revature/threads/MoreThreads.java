package com.revature.threads;

public class MoreThreads {
	
	public static int balance = 0;

	public static void main(String[] args) throws InterruptedException {
		Bank b = new Bank();
		for(int i = 0; i < 10; i++) {
			//conncurrentChanges();
			synchronizedChanges(b);
			System.out.println(b.balance);
		}
		
	}
	
	public static void conncurrentChanges() throws InterruptedException {
		Thread earner = new Thread(()->{
			for(int i = 0; i < 100; i++) {
				System.out.println("earner: " + balance);
				System.out.println("earner iteration: " + i);
				balance += i;
			}
		});
		Thread spender = new Thread(()->{
			for(int i = 0; i < 100; i++) {
				System.out.println("spender: " + balance);
				System.out.println("spender iteration: " + i);
				balance -= i;
			}
		});
		earner.start();
		spender.start();
		
	}
	
	public static void synchronizedChanges(Bank b) throws InterruptedException {
		Thread earner = new Thread(()->{
			for(int i = 0; i < 100; i++) {
				b.deposit(i);
			}
		});
		Thread spender = new Thread(()->{
			for(int i = 0; i < 100; i++) {
				b.withdraw(i);
			}
		});
		earner.start();
		spender.start();
		
		//halt main thread execution until these threads complete
		earner.join();
		spender.join();
	}

}
