package com.revature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class HelloJUnit {

	@BeforeClass
	public static void setupClass() {
		System.out.println("Before Class");
		//this is where we put any setup logic
		//that would be needed before we can run
		//any tests
	}
	
	@Before
	public void setup() {
		System.out.println("@Before");
		//this is where we would put any setup logic
		//that would need to be executed before each
		//individual test
	}
	
	@Test
	public void test() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@After
	public void teardown() {
		System.out.println("@After");
		//this is where you put logic to 'reset'
		//the state of your app, after each individual test
	}
	
	@AfterClass
	public static void teardownClass() {
		System.out.println("After Class");
		//this is where you put logic to reset
		//any changes that your tests or setup methods
		//may have made
	}
	
}
