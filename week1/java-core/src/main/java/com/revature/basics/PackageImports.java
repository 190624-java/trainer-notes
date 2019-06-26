package com.revature.basics;

//import statements must come after package statements.
import java.lang.Math;
import java.util.LinkedList;
import java.util.Scanner;

//static import: allows you to use static methods of a class
//without referencing the class name.
import static java.lang.Math.abs;
import static java.lang.Math.*;

public class PackageImports {

	public static void main(String[] args) {

		Math.abs(5.777);
		//new Scanner(System.in);
		
		new LinkedList();
		abs(123);
		
		//fully qualified class name
		java.util.List list;
		java.awt.List awtList;
	}

}
