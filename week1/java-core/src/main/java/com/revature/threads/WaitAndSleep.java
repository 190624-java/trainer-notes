package com.revature.threads;

import java.util.Scanner;

public class WaitAndSleep {

	public static void main(String[] args) throws InterruptedException {
		Kitten k = new Kitten();
		Thread t1 = new Thread(()->{
			try {
				k.waitForFood();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		Thread stateReader = new Thread(()->{
			while(t1.isAlive()) {
				System.out.println("t1 state: " + t1.getState());
			}
		});
		stateReader.start();
		Thread.sleep(2000);//ensures first thread gets to waiting state
		k.feed();//notifies (wakes up) waiting thread
		
		//sleep example
		Thread t2 = new Thread(()->{
			k.nap();
		});
		t2.start();
//		new Thread(()->{
//			while(t2.isAlive()) {
//				System.out.println("t2 state: " + t2.getState());
//			}
//		}).start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		t2.interrupt();
		//calling interrupt on a thread, throws it an Interrupted
		//Exception
		scanner.close();
		
	}

}
