package com.revature.fileIOReview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeroPersistance {

	public static String filename = "hero-data.ser";

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		addNewHero(new Hero("Hawkmoon", "fire", "druid", 60));
		addNewHero(new Hero("Belith", "nature", "druid", 60));
		// keep in mind that every time you run this class
		//both of these heroes will be added again.
		List<Hero> heroes = getAllHeroes();
		if (heroes != null && heroes.size() > 0) {
			for (Hero h : heroes) {
				System.out.println(h.name);
			}
		}
		String name, element, heroClass;
		int level;
		Scanner reader = new Scanner(System.in);
		System.out.print("Name: ");
		name = reader.nextLine();
		System.out.print("\nElement: ");
		element = reader.nextLine();
		System.out.print("\nClass: ");
		heroClass = reader.nextLine();
		System.out.print("\nLevel: ");
		level = reader.nextInt();
		reader.close();
		addNewHero(new Hero(name, element, heroClass, level));
		heroes = getAllHeroes();
		if (heroes != null && heroes.size() > 0) {
			for (Hero h : heroes) {
				System.out.println(h.name);
			}
		}

	}

	public static void addNewHero(Hero hero) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Hero> league = getAllHeroes();
		//Having this inside of the try was causing issues,
		//because you can't have an input stream and an output stream
		//on the same file at the same time.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)))) {
			
			if (league != null) {
				System.out.println("Heroes found");
				league.add(hero);
			} else {
				league = new ArrayList<Hero>();
				league.add(hero);
			}
			oos.writeObject(league);
			System.out.println("New list written");
		}
	}

	public static List<Hero> getAllHeroes() throws IOException, ClassNotFoundException {
		List<Hero> league = null;
		try (ObjectInputStream str = new ObjectInputStream(new FileInputStream(new File("hero-data.ser")))) {
			league = (List<Hero>) str.readObject();
			System.out.println(league);
		} catch (FileNotFoundException e) {
			return new ArrayList<>();
		}
		return league;
	}

}
