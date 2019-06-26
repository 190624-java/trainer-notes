package com.revature.basics;

public class MutableStrings {

	public static void main(String[] args) {
		//Mutable Strings, don't use the string pool.
		StringBuilder str = new StringBuilder("Java");
		StringBuilder str2 = new StringBuilder("Java");
		System.out.println(str == str2);
		System.out.println(str.hashCode());
		str.append(" ").append("is cool!").replace(0, 4, "Jessica")
			.deleteCharAt(str.length() -1).append("...");
		System.out.println(str);
		System.out.println(str.hashCode());
		
		doNotDoThisEVER();
		
		StringBuffer str3 = new StringBuffer("Hi");
	}
	
	public static void doNotDoThisEVER() {
		String str = "Java";
		str += " ";
		str += "is cool!";
		str = "Jessica" + str.substring(4, str.length());
		str = str.replace("!", "...");
		System.out.println(str);
	}

}
