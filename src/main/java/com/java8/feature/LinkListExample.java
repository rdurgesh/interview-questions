package com.java8.feature;

import java.util.LinkedList;

public class LinkListExample {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.addFirst(2);
		linkedList.addLast(3);
		linkedList.forEach(System.out::println);
	}
}
