package com.revature.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		Serialization x = new Serialization();
		x.write();
		x.read();
	}
	
	public static final String file = "cereal.ser";
	
	public void write() {
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(file)))){
			CerealBox obj = new CerealBox(true, "General Mills",
					"Lucky Charms", 8);
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(new File(file)))){
			CerealBox obj = (CerealBox) ois.readObject();
			System.out.println(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
