package com.java.interview.example;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InterviewTest {

	@Test
	public void shouldremoveTheDuplicate() {
		List<String> data = Arrays.asList("Durgesh", "Ramesh", "Durgesh", "Ajay", "Nagesh", "Ramesh");
		List<String> expected = Arrays.asList("Durgesh", "Ramesh", "Ajay", "Nagesh");
		InterviewQuestion interviewTest = new InterviewQuestion();

		assertTrue(Arrays.deepEquals(expected.toArray(), interviewTest.removeDuplicateString(data).toArray()));
	}

	@Test
	public void shouldRemoveTheDuplicatePersons() {
		InterviewQuestion interviewTest = new InterviewQuestion();
		List<Person> personData = Arrays.asList(new Person("Durgesh", 1), new Person("Durgesh", 1),
				new Person("Sagar", 2));
		List<String> expectedData = Arrays.asList("Durgesh", "Sagar");
		List<String> actualData = interviewTest.removeDuplicateObject(personData);

		assertTrue(Arrays.deepEquals(expectedData.toArray(), actualData.toArray()));
	}

	@Test
	public void shouldCheckAnnagram() {
		String str1 = "Mary";
		String str2 = "Army";
		InterviewQuestion interviewTest = new InterviewQuestion();
		assertTrue(interviewTest.isAnngram(str1, str2));
	}
}
