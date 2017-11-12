package com.java.interview.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQuestion {

	// removing duplicate string form array list
	public List<String> removeDuplicateString(List<String> data) {
		return data.stream().distinct().collect(Collectors.toList());
	}

	// removing duplicate object based on some property field
	public List<String> removeDuplicateObject(List<Person> data) {
		return data.stream().map(p -> p.getName()).distinct().collect(Collectors.toList());
	}

	public boolean isAnngram(String str1, String str2) {
		char[] chars1 = str1.toLowerCase().toCharArray();
		char[] chars2 = str2.toLowerCase().toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
}
