package com.java8.feature;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamExamples {

	public static void main(String[] args) {

		// Find all numbers between 1 to 5
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

		IntStream intStream2 = IntStream.of(new int[] { 1, 2, 3, 4, 5 });

		IntStream intStream3 = IntStream.range(1, 6);

		intStream.forEach(System.out::println);
		intStream2.forEach(System.out::println);
		intStream3.forEach(System.out::println);

		// Find all even numbers between 1 to 5
		System.out.println("******************************Even Number Between 1 to 5********************************");
		IntStream.of(1, 2, 3, 4, 5).filter(n -> n % 2 == 0).forEach(System.out::println);
		IntStream.of(new int[] { 1, 2, 3, 4, 5 }).filter(n -> n % 2 == 0).forEach(System.out::println);
		IntStream.range(1, 6).filter(n -> n % 2 == 0).forEach(System.out::println);

		// Find all numbers greater than 2 in 1 to 5
		System.out.println("*********Find all numbers greater than 2 in 1 to 5*************");
		IntStream.of(1, 2, 3, 4, 5).filter(n -> n > 2).forEach(System.out::println);
		IntStream.of(new int[] { 1, 2, 3, 4, 5 }).filter(n -> n > 2).forEach(System.out::println);
		IntStream.range(1, 6).filter(n -> n > 2).forEach(System.out::println);

		// Find all even numbers greater than 2 in 1 to 5
		IntStream.range(1, 5).filter(n -> n > 2).filter(n -> n % 2 == 0).forEach(System.out::println);

		IntStream.range(1, 6).filter(n -> n % 2 == 1).forEach(System.out::println);

		// Find sum of all between 1 to 5
		int sum = IntStream.range(1, 6).sum();
		System.out.println(sum);

		int sum1 = IntStream.range(1, 5).filter(n -> n % 2 == 0).sum();
		System.out.println(sum1);

		// Find maximum of all numbers in given numbers
		OptionalInt max = IntStream.of(2, 6, 9, 14, 56).max();
		System.out.println(max.getAsInt());

		// Find minimum of all numbers in given numbers
		OptionalInt min = IntStream.of(2, 5, 6, 1, 3).min();
		System.out.println(min.getAsInt());

		long count = IntStream.range(3, 6).count();
		System.out.println(count);

		// n.e. 1 + 2 + 3 + 4 + 5
		OptionalDouble average = IntStream.of(1, 2, 3).average();
		System.out.println("average = " + average.getAsDouble());

		int first = IntStream.of(1, 2, 3).findFirst().getAsInt();
		System.out.println(first);

		int any = IntStream.of(1, 2, 3).findAny().getAsInt();
		System.out.println(any);

		boolean anyRecordgreaterThan5 = IntStream.of(2, 5, 6, 1, 3).anyMatch(n -> n > 5);
		System.out.println(anyRecordgreaterThan5);

		boolean allRecordGreaterThan = IntStream.of(2, 5, 6, 1, 3).allMatch(n -> n > 5);
		System.out.println(allRecordGreaterThan);

		boolean noneRecordGreaterThan = IntStream.of(2, 5, 6, 1, 3).noneMatch(n -> n > 6);
		System.out.println(noneRecordGreaterThan);

		int sumReduce = IntStream.of(2, 5, 6, 1, 3).reduce((x, y) -> x + y).getAsInt();
		System.out.println(sumReduce);
		int sumReduce2 = IntStream.of(4, 5, 6, 2).reduce(10, (x, y) -> x + y);
		System.out.println(sumReduce2);
	}

}
