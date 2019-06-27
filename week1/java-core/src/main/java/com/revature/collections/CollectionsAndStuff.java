package com.revature.collections;

import java.util.*;

public class CollectionsAndStuff {

	public static void main(String[] args) {
		/* Collection classes are generics, they take parameters
		 *of any type of object.
		 * generics give type-safety.
		 * <> diamond operator comes from Java7+, infers type from reference
		 * 
		 * 
		 * Ordered Collections: maintain INSERTION order
		 */
		List<Person> doublyLinkedList = new LinkedList<>();
		// LinkedList inherits from List, Queue, and Deque
		doublyLinkedList.add(new Person());
		doublyLinkedList.contains(new Person());
		
		List<Person> arrayBackedList = new ArrayList<>();
		//grow 50% when the capacity is reached.
		
		List<Person> a = new Vector<>();
		//vectors are synchronized, grow 2x when they reach capacity
		
		for(ListIterator iterator = a.listIterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			iterator.previous();
		}
		// Iterator objects allow you to move forward through a collection
		//ListIterator objects allow you to move forward or backward
		
		/*
		 * Sorted Collections: maintain NATURAL order
		 * (aka, they use the compareTo method to order)
		 * - TreeSet
		 * 
		 * Sets are all unique
		 * => anything that inherits from Set, does not contain
		 * duplicate elements
		 *
		 * NOT Sorted or Ordered: HashSet
		 * Ordered but not Sorter: LinkedHashSet
		 *
		 * Queue/ Deque
		 * LinkedList implements List, Queue, and Deque
		 * 
		 * Sorted Queues: PriorityQueue
		 * 
		 * Synchronized Array-Backed Queue:  ArrayBlockingQueue
		 * 
		 * Deque - allows you to add/remove from the front or the back
		 * 
		 */
		
		//Iterator example
		LinkedList<Person> personList = new LinkedList<>();
		//one way to iterate through a list
		for(Person p : personList) {
			System.out.println(p.getName());
		}
		
		System.out.println(personList.iterator());
		for(Iterator i = personList.iterator(); i.hasNext();) {
			Person person = (Person) i.next();
			System.out.println(person.getName());
		}
		
		//to go backwards through a list we can use the ListIterator
		//previous method
		for(int i = 0; i < personList.size(); i++) {
			Person person = personList.get(personList.size()-1-i);
			System.out.println(person.getName());
		}
		
		for(ListIterator li = personList.listIterator(); li.hasNext();) {
			Person person = (Person) li.next();
			if(li.hasPrevious()) {
				Person p = (Person) li.previous();
				System.out.println(p.getName());
				li.next();
			}
		}
		/*
		 * to recap:
		 * 	an Iterator object is what allows you to traverse
		 * the elements in a collection
		 */
		
		/* Maps
		 * - are NOT collections (in the sense that they don't inherit
		 * 			from Collection)
		 * - which means they aren't iterable.
		 * - table-like structures
		 * - key-value pairs, where keys are unique.
		 * - keys are used to idenfity and access values.
		 * - kinda like dictionaries
		 */
		
		Map<String, Person> keyValuePair = new HashMap<>();
		keyValuePair.put("abc", new Person());
		Person p1 = keyValuePair.get("abc"); //access values by keys, this returns the value
		keyValuePair.put("abc", new Person("Minnie", 5));
		Person p2 = keyValuePair.get("abc");
		System.out.println(p1 == p2);
		keyValuePair.putIfAbsent("abc", new Person("Mickey", 6));
		Person p3 = keyValuePair.get("abc");
		System.out.println(p2 == p3);
		
		//Hashtable is synchronized map
		Map<String, Person> oldSyncMap = new Hashtable<>();
		//same methods as hashmap
		
		//LinkedHashMap maintains insertion order (ordered)
		Map<String, Person> orderedMap = new LinkedHashMap<>();
		
		//TreeMap which is sorted (natural order)
		Map<String, Person> sortedMap = new TreeMap<>();
		//same methods.
		
		
		//sort a List by natural ordering (uses compareTo method)
		Collections.sort(personList);
		
		//if you wish to sort by some other ordering, 
		// you need to create a comparator
		//using static inner class
		Collections.sort(personList, new Person.PersonAgeComparator());
		
		Person.sortByAge(personList);
		/*
		 * if we were using a non-static inner class
		 * 
		 * Collections.sort(personList, 
		 * 			new Person().new PersonAgeComparator());
		 */
		
	}

}
