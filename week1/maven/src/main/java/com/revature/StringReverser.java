package com.revature;

public class StringReverser {
	
	public String reverse(String forward) {
		StringBuilder strBuild = new StringBuilder(forward).reverse();
		return strBuild.toString();
	}
}
