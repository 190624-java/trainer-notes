package com.revature;

/*
 * Test Driven Development (TDD)
 * - development methodology that involves writing test classes
 * first. The classes should be written such that if they pass
 * they meet a particular requirement.
 * - and theeeennnn after all of your tests are written. 
 * 		1. They will all fail.
 * 		2. You write your code to make the tests pass.
 * 		3. Run your tests, to make sure they pass.
 * 			- if they don't, you DO NOT CHANGE YOUR TESTS.
 * 			You change your code.
 * 		4. Then you can re-factor your code.
 * 
 * Unit Tests
 * - jUnit is a framework for writing unit tests
 * - unit tests are test methods that test a particular unit of code
 * to ensure that it operates appropriately in all cases.
 * - your goal is to achieve the highest level of code coverage
 * that you can.
 * - Best practice is to test ALL cases.
 * 		- Positive cases, negative cases, single cases, bulk cases
 * 		- Test User permissions
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseStringTest {
	
	@Test
	public void testReverse() {
		/*
		 * Test classes must have a void return type
		 * and take no input parameters
		 */
		String forward = "Hello";
		StringReverser rev = new StringReverser();
		String result = rev.reverse(forward);
		
		assertEquals("olleH", result);
		
		forward = "Hello World!";
		result = rev.reverse(forward);
		assertEquals("!dlroW olleH", result);
	}
	
}
