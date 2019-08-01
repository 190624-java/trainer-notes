package com.revature.aop.service;

import org.springframework.stereotype.Service;

/**
 * The enter() and exit() methods are both Join Points.
 * @author Revature
 *
 */

@Service
public class Building {
	
	public void enter() {
		System.out.println("Entering Building...");
	}
	
	public void exit() {
		System.out.println("Exiting Building...");
	}
}
