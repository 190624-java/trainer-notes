package com.revature.basics;

public class Strings {

	public static void main(String[] args) {
		// They are not primitive!
		String str = "not primitive!";
		//use the 'string pool'
		String str2 = "not primitive!";
		System.out.println(str == str2);
		
		//by using the String constructor,
		//you're actually bypassing the String Pool
		String isObject = new String("not primitive!");
		System.out.println(str == isObject);
		System.out.println(str.equals(isObject));
		
		//immutable - they don't change, you can't change them.
		System.out.println(str.hashCode());
		str = str.concat("!");
		System.out.println(str.hashCode());
		System.out.println(str2);
		System.out.println(str);
		
		//String API
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		str += "!";// equal to str = str + "!";
		
		boolean hasNotInIt = str.contains("not");
		System.out.println(hasNotInIt);
		hasNotInIt = str.contains("Not");
		System.out.println(hasNotInIt);
		
	}

}
