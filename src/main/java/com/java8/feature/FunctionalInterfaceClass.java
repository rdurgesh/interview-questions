package com.java8.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceClass {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Manish", "Nivas", "", "Sri", "Abhi", null);
		List<Number> values = Arrays.asList(123, 0, 45, 3, 0, 23, 0, 34);

		System.out.println("==========================Predicate==========================");
		Predicate<String> nonEmptyString = (s) -> s != null && !s.isEmpty();
		System.out.println(filter(names, nonEmptyString));

		System.out.println("=============================Consumer==========================");
		Consumer<Number> printNumConsumer = (val) -> System.out.println(val);
		Consumer<String> printStringConsumer = (val) -> System.out.println(val);
		printEach(names, printStringConsumer);
		printEach(values, printNumConsumer);

		System.out.println("========================Function================================");
		Function<String, Integer> length = (s1) -> s1.length();
		System.out.println(findLength(filter(names, nonEmptyString), length));

		System.out.println("========================Unary Operator===========================");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		UnaryOperator<Integer> operator = in -> in * 10;
		List<Integer> result = testUnary(numbers, operator);
		result.forEach(System.out::println);
		result = testUnary(numbers, in -> in * 10);
		result.forEach(System.out::println);
		result = testUnary(numbers, (in) -> in + 10);
		result.forEach(System.out::println);
		System.out.println("==============BiFunction============");
		BiFunction<Integer, Integer, String> biFunction = (a, b) -> " " + a * b;
		System.out.println(biFunction.apply(10, 20));

		Function<String, Integer> stringConversion = (st) -> Integer.parseInt(st);
		Function<String, Integer> stringConversion1 = Integer::parseInt;
		Integer int1 = transForm(stringConversion, "123");
		Integer int2 = transForm(stringConversion1, "123");
		Integer int3 = transForm(Integer::parseInt, "123");
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		list.forEach(obj -> {
			if (predicate.test(obj))
				result.add(obj);
		});
		return result;
	}

	public static <T> void printEach(List<T> data, Consumer<T> consumer) {
		data.forEach(obj -> {
			consumer.accept(obj);
		});
	}

	public static List<Integer> findLength(List<String> data, Function<String, Integer> function) {
		List<Integer> result = new ArrayList<>();
		data.forEach(obj -> {
			result.add(function.apply(obj));
		});
		return result;
	}

	public static List<Integer> testUnary(List<Integer> data, UnaryOperator<Integer> operator) {
		List<Integer> result = new ArrayList<>();
		data.forEach(obj -> {
			result.add(operator.apply(obj));
		});
		return result;
	}

	public static Integer transForm(Function<String, Integer> function, String str) {
		return function.apply(str);
	}
}
