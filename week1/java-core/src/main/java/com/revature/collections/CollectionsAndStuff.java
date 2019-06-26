package com.revature.collections;

import java.util.*;

public class CollectionsAndStuff {

	public static void main(String[] args) {
		// Collection classes are generics, they take parameters
		//of any type of object.
		// generics give type-safety.
		// <> diamond operator comes from Java7+, infers type from reference
		
		/*
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
		 */
		
		/*
		 * NOT Sorted or Ordered: HashSet
		 * Ordered but not Sorter: LinkedHashSet
		 */
		
		/*
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
		
		/* Maps
		 * -
		 */
	}

}
