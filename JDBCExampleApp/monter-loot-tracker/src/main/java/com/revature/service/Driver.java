package com.revature.service;

import java.util.Scanner;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.dbDAOimpls.*;

public class Driver {
	
	public static PlayerDAO playerDAO = new PlayerDAOImpl();

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Would you like to create a new player? (y/n) ");
			String resp = scan.next();
			switch (resp) {
			case "y": {
				System.out.println();
				System.out.print("Username: ");
				String username = scan.next();
				System.out.print("Player Level: ");
				int level = scan.nextInt();
				Player p = new Player(username, level);
				p = playerDAO.createPlayer(p);
				System.out.println("A new player has been created!");
				System.out.println(p.toString());
				break;
			}
			case "n": {
				System.out.println("Ok...");
				break;
			}
			default: {
				break;
			}
			}
		}

	}

}
