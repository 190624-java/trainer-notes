package com.revature.basics;

public class GarbageCollection {
	static Trash trash = new Trash();
	
	public static void main(String[] args) {
		/*trash = null;//*
		System.gc();
		for (;;) {}
		*/
		swap();
	}
	
	public static void clean() {
		Trash bag = new Trash();
	}// bag is out of scope => eligible for gc
	
	public static void swap() {
		Trash a = new Trash();
		System.out.println(a);
		a = new Trash();
		System.out.println(a);
		// the first Trash object, is not able to be referenced,
		// so it is eligible for gc
	}

}

class Trash {
	@Override
	protected void finalize() {
		while(this != null) {
			System.out.println("Trash");
		}
	}
}
