package com.java.interview.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterviewQuestion {
	
	// removing duplicate string form array list
	public List<String> removeDuplicateString(List<String> data) {
		return data.stream().distinct().collect(Collectors.toList());
	}

	// removing duplicate integer form array list
	public List<Integer> remove(List<Integer> data) {
		return data.stream().distinct().collect(Collectors.toList());
	}

	// removing duplicate object based on some property field
	public List<Person> removeDuplicateObject(List<Person> list) {
		return list.stream().filter(distinctByKey(p -> p.getName())).collect(Collectors.toList());
	}

	public int[] removeDuplicateNumber(int[] arrays) {

		int index = 0;

		int[] uniqueArray = new int[arrays.length];

		for (int element : arrays) {
			if (!isElementExist(uniqueArray, element)) {
				uniqueArray[index] = element;
				index++;
			}
		}
		int[] temp = new int[index];
		for (int k = 0; k < index; k++) {
			temp[k] = uniqueArray[k];
		}
		return temp;
	}

	private boolean isElementExist(int[] array, int element) {
		for (int data : array) {
			if (element == data) {
				return true;
			}
		}
		return false;
	}

	public List<Person> removeDuplicate(List<Person> data) {

		Person lokesh = new Person(1, "Lokesh", "Gupta");
		Person brian = new Person(2, "Brian", "Clooney");
		Person alex = new Person(3, "Alex", "Kolen");

		// Add some random persons
		Collection<Person> list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);

		// Get distinct only
		List<Person> distinctElements = list.stream().filter(distinctByKey(p -> p.getId()))
				.collect(Collectors.toList());

		// Let's verify distinct elements
		System.out.println(distinctElements);

		return distinctElements;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	// finding the anagrams string
	public boolean isAnagram(String str1, String str2) {
		char[] chars1 = str1.toLowerCase().toCharArray();
		char[] chars2 = str2.toLowerCase().toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
}
