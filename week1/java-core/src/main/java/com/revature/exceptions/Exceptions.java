package com.revature.exceptions;

public class Exceptions {

	public static void main(String[] args) {
		try {
			handle();
		} catch (Exception e) {
			System.out.println("handled!");
		}
		
		
	}
	
	public static void jump() throws FallException{
		//this is called 'ducking'
		boolean notOverTrampoline = true;
		if(notOverTrampoline) {
			throw new FallException();
		}
		System.out.println("Having a good time");
	}
	
	public static void hop(){
		throw new TripException();
	}
	
	public static void duck() throws FallException {
		jump();
	}
	
	public static void handle() {
		try {
			//any logic that may throw an exception
			duck();
			System.out.println("My duck didn't thrown an exception");
		} catch (FallException e) {
			//log and either rethrow an exception, or
			// we do something to recover execution
			System.out.println("Oh No! Exception");
			throw new TripException();
		} catch (TripException te) {
			System.out.println("Tripped!");
		} catch (Exception ex) {
			System.out.println("I don't know what went wrong ):");
		} finally {
			//any logic here will execute no matter what.
			System.out.println("Finally!!");
		}
		System.out.println("Below Finally");
	}

}

//checked, compiler forces you to handle.
class FallException extends Exception {}

//unchecked, compiler doesn't force you to handle these.
class TripException extends RuntimeException{}
