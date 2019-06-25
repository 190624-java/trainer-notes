package com.revature.basics;

public class ControlFlow {

	public static void main(String[] args) {
		//if-else
		if(5 == 4) {
			System.out.println("The world might be ending");
		} else {
			System.out.println("Everything is OK!");
		}
		
		if('x' == 'y' || 5 == 4) {
			//do something
		} else if('x' == 'z') {
			//do something different
		} else {
			//if all else fails, do this.
		}
		
		//while loops
		boolean flag = true;
		while(flag) {
			//logic
			//DO NOT FORGET AN EXIT CONDITION
			flag = false;
		}
	
		//do while loops
		do {
			//logic
			//again DONT FORGET AN EXIT CONDITION
		} while (flag);
		
		//for
		for(int i=0; i<10; i++) {
			//logic here
		}
		
		//for-each
		int[] arr = new int[5];
		for(int x : arr) {
			// do not try to affect the array! (arr)
			//logic here
		}
		
		//switch
		char choice = 'A';
		
		switch(choice) {
		case 'A': {
			//do something
			break;
		}
		case 'B': {
			//do something else
			break;
		}
		default: {
			//other things to do
			break;
		}
		}

	}//end main

}
