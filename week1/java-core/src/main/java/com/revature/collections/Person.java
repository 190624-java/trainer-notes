package com.revature.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	private Person[] friends;
	
	public Person() {
		this.friends = new Person[20];
	}
	public Person(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person[] getFriends() {
		return friends;
	}
	public void setFriends(Person... friends) {
		this.friends = friends;
	}
	public void addFriends(Person... friends) {
		//... -> var args
		int j = 0;
		for(int i = 0; i < 20; i++) {
			if(this.friends[i] == null && j < friends.length) {
				this.friends[i] = friends[j]; 
				j++;
			}
		}
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", friends=" + Arrays.toString(friends) + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + Arrays.hashCode(friends);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (!Arrays.equals(friends, other.friends))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/*
	 * used to determine sorting of objects in a SORTED collection.
	 * you want to implement compareTo in such a way
	 * that it orders People NATURALLY
	 */
	@Override
	public int compareTo(Person other) {
		return this.name.compareTo(other.name);
		//if you return 0 => they are the same in terms of order
		//if you return -number => this comes before other
		//if you return +number => this comes after other
	}
	
	public static void sortByAge(List<Person> personList) {
		Collections.sort(personList, new Person.PersonAgeComparator());
	}
	
	//You can have nested class (inner classes)
	static class PersonAgeComparator implements Comparator<Person> {
		public int compare(Person one, Person other) {
			return one.age - other.age;//youngest to oldest
			//return other.age - one.age; //oldest to youngest
		}
	}
	
	//can have as many inner classes as you want
	static class PersonPopularComparator implements Comparator<Person> {
		public int compare(Person one, Person other) {
			return other.friends.length - one.friends.length;
			// person with more friends goes before person with less
		}
	}
	
	static class PersonHeightComparator {}
	static class PersonAwesomenessComparator {}
	
}//ends person class
