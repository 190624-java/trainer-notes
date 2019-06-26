package com.revature.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreams {

	public static void main(String[] args) throws IOException {
		CharStreams x = new CharStreams();
		x.read();
		x.write();
		x.read();
		
		x.userInput();
	}
	
	
	public void read() {
		File file = new File("hello.txt");
		try (FileReader reader = new FileReader(file)){
			int c = reader.read();
			while(c != -1) {
				System.out.print((char)c);
				c = reader.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("hello.txt does not exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//file writer works with chars/strings
	public void write() throws IOException {
		//could use try with resources, like above, 
		//but could also just do it this way
		File file = new File("hello.txt");
		FileWriter writer = new FileWriter(file, true); //true - want to append content
		writer.write("Hello World");
		writer.append('!');
		writer.append('\n');
		writer.close();
	}
	
	public void userInput() {
		/*
		 * System.in is an InputStream that
		 * represents keyboard input
		 */
		try(Scanner scanner = new Scanner(System.in)){
			//String s = scanner.next();//breaks at a space
//			String s = scanner.nextLine(); //breaks at the end of a line
//			System.out.println("How are you?");
//			String s1 = scanner.nextLine();
//			System.out.println(s1);
			String reply = null;
			int count = 0;
			System.out.println("Want to add numbers?");
			reply = scanner.next();
			while(!reply.equalsIgnoreCase("Stop")) {
				if(reply.contains("y") || reply.contains("Y")) {
					count++;
					System.out.println("Count is at: " + count);
				} else {
					System.out.println("Count is " + count);
				}
				System.out.println("Type Stop if you wish to stop");
				System.out.println("Continue?(stop/continue)");
				reply = scanner.next();
			}
		}
	}

}
