package com.java.interview.example;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		reverseString.reverseTheGivenString("ABCDEF");
	}

	public void reverseTheGivenString(String str) {
		String message = str;
		StringBuffer buffer = new StringBuffer(message);
		System.out.println(buffer.reverse());

		char[] chars = message.toCharArray();
		int length = chars.length;
		char[] temp = new char[length];
		for (int i = 1; i <= length; i++) {
			temp[i - 1] = chars[length - i];
		}
		System.out.println(String.valueOf(temp));
	}

	public String findtheHighestRepeatedValue(String[] values) {
		Map<String, Integer> map = new HashMap<>();
		for (String key : values) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		List<String> keys = new ArrayList<>(map.keySet());
		List<Integer> mapValues = new ArrayList<>(map.values());
		Collections.sort(keys);
		Collections.sort(mapValues);
		int size = mapValues.size();
		String highestVotedName = "";
		if (mapValues.get(size - 1) == mapValues.get(size - 2)) {
			highestVotedName = keys.get(keys.size() - 1);
		} else {
			for (String key : keys) {
				if (map.get(key) == mapValues.get(size - 1)) {
					highestVotedName = key;
				}
			}
		}
		return highestVotedName;
	}

	@Test
	public void shouldReturnMostRepeatedName() {
		ReverseString reverseString = new ReverseString();
		String[] array = { "Durgesh", "Lokesh", "Durgesh", "Akhilesh", "Pradeep", "Lokesh", "LastName" };
		String[] array1 = { "Durgesh", "Lokesh", "Durgesh", "Akhilesh", "Pradeep", "Nilesh", "LastName" };
		assertSame("Pradeep", reverseString.findtheHighestRepeatedValue(array));
		assertSame("Durgesh", reverseString.findtheHighestRepeatedValue(array1));
	}
}
