package com.java.interview.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InterviewTest {

	@Test
	public void shouldremoveTheDuplicate() {
		InterviewQuestion interviewTest = new InterviewQuestion();
		List<String> data = Arrays.asList("Durgesh", "Ramesh", "Durgesh", "Ajay", "Nagesh", "Ramesh");
		List<String> expected = Arrays.asList("Durgesh", "Ramesh", "Ajay", "Nagesh");
		List<String> actual = interviewTest.removeDuplicateString(data);

		assertTrue(Arrays.equals(expected.toArray(), actual.toArray()));
	}

	@Test
	public void shouldRemoveTheDuplicatePersons() {
		InterviewQuestion interviewTest = new InterviewQuestion();
		List<Person> personData = Arrays.asList(new Person("Durgesh", 1), new Person("Durgesh", 1),
				new Person("Sagar", 2));
		List<Person> expectedData = Arrays.asList(new Person("Durgesh", 1), new Person("Sagar", 2));
		List<Person> actualData = interviewTest.removeDuplicateObject(personData);

		assertTrue(Arrays.deepEquals(expectedData.toArray(), actualData.toArray()));
	}

	@Test
	public void shouldCheckAnnagram() {
		String str1 = "Mary";
		String str2 = "Army";
		InterviewQuestion interviewTest = new InterviewQuestion();
		assertTrue(interviewTest.isAnagram(str1, str2));
		assertFalse(interviewTest.isAnagram(str1, "armmy"));
	}

	@Test
	public void removeDuplicateNumber() {
		InterviewQuestion interviewQuestion = new InterviewQuestion();
		int[] arrays = { 1, 1, 5, 6, 8, 5, 9, 7, 5 };
		int[] array = interviewQuestion.removeDuplicateNumber(arrays);
		System.out.println(Arrays.toString(array));
	}
}
