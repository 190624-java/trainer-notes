package com.revature.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineStreams {

	public static void main(String[] args) {
		
		LineStreams x = new LineStreams();
		x.write();
		x.read();

	}
	
	private static final String file = "src/main/resources/heroes.txt";
	
	public void write() {
		try (PrintWriter writer = new PrintWriter(new 
				FileOutputStream(new File(file)))){
			writer.println("Dan,25,Mage");
			writer.println("Randolph,30,Paladin");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
			e.printStackTrace();
		}
	}
	
	public void read() {
		try(Scanner scanner = new Scanner(new 
				FileInputStream(new File(file)))){
			while(scanner.hasNextLine()) {
				String data = scanner.nextLine();
				Scanner line = new Scanner(data);
				line.useDelimiter(",");
				System.out.println("Hero: " + line.next() +
						"\nLevel: " + line.next() +
						"\nClass: " + line.next());
				line.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
			e.printStackTrace();
		}
	}

}
