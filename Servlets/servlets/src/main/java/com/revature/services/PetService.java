package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Pet;

public class PetService {
	
	public static List<Pet> pets = new ArrayList<>();
	
	static {
		pets.add(new Pet(1, "Scar", "Cat"));
		pets.add(new Pet(2, "Mufasa", "Cat"));
		pets.add(new Pet(3, "Pickle", "Dog"));
	}

	public static List<Pet> getAllPets(){
		return pets;
	}
	
}
