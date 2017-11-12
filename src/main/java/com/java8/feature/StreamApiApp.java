package com.java8.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiApp {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Sri", "Manish", "Dande", "Ranjan", "Sri", "Ram", "Abhi", "Shyam", "Manish");
		System.out.println(list);
		list.forEach(System.out::println);
		List<String> result = list.stream().filter(nm -> nm.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);
		long count = list.stream().filter(nm -> nm.startsWith("S")).count();
		System.out.println(count);
		List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctList);
		System.out.println(list.stream().allMatch(nm -> nm.contains("s")));
		System.out.println(list.stream().anyMatch(nm -> nm.contains("a")));
		List<String> newlist = Arrays.asList("Sri", "Manish", "Dande", "Ranjan", "Sri", "Ram", "Abhi", "Shyam",
				"Manish");
		List<String> newResult = newlist.stream().limit(4).collect(Collectors.toList());
		System.out.println(newlist);
		System.out.println(newResult);
		newResult = newlist.stream().skip(5).collect(Collectors.toList());
		System.out.println(newResult);
		Stream<String> stream = newlist.stream();
		Stream<String> streams = newlist.stream();
		stream.forEach(System.out::println);
		streams.forEachOrdered(System.out::println);

		System.out.println("============================MAP======================================");
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(123, "Sri");
		map.put(345, "Kumar");
		map.put(44, "Manish");
		map.put(99, "Abhi");
		map.put(88, "Dande");
		map.put(189, "Rahul");
		map.forEach((key, value) -> System.out.println("sid" + key + ",\t Name:" + value));
		System.out.println(map.get(123));
		System.out.println(map.getOrDefault(123, "Durgesh"));
		System.out.println(map.get(89));// returns null
		System.out.println(map.getOrDefault(89, "Durgesh"));// returns Durgesh
		System.out.println("***************************");
		System.out.println(map);
		map.put(123, "Nivas");
		System.out.println(map);
		map.put(123, "Ranjan");
		map.putIfAbsent(78, "Manoj");
		System.out.println(map);
		map.remove(88);
		System.out.println(map);
		map.remove(44, "Sri");
		System.out.println(map);

		System.out.println("=============================Flat Map===============================================");
		List<String> words = Arrays.asList("Hello", "World", "Durgesh");
		System.out.println("words = " + words);
		List<String[]> wordsresult = words.stream().map(word -> word.split("")).distinct().collect(Collectors.toList());
		System.out.println("wordresult = " + wordsresult);

		List<String> resultChars = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		System.out.println("resultChars = " + resultChars);

		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		Collections.sort(list, comp);
		System.out.println(list);

		List<NewStudent> studentList = Arrays.asList(new NewStudent("Sri", 100), new NewStudent("Manish", 200),
				new NewStudent("Abhi", 50), new NewStudent("Rahul", 100));

		int totalFee = studentList.stream().map(NewStudent::getFeePaid).reduce(0, Integer::sum);
		System.out.println("totalFee = " + totalFee);

		int totalFee1 = studentList.stream().mapToInt(NewStudent::getFeePaid).sum();
		System.out.println("totalFee1 = " + totalFee1);
	}
}

class NewStudent {
	String name;
	int feePaid;

	public NewStudent(String name, int feePaid) {
		super();
		this.name = name;
		this.feePaid = feePaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(int feePaid) {
		this.feePaid = feePaid;
	}

}
