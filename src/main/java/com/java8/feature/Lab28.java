package com.java8.feature;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lab28 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Dande", "Ranjan", "Nivas", "Manish");
		NameDescComparator comp = new NameDescComparator();
		Collections.sort(names, comp);
		System.out.println(names);
		UsingJav8 jav8 = new UsingJav8();
		jav8.shortData(names);
		List<Student> studends = Arrays.asList(new Student(56, "Manish"), new Student(12, "Nivas"),
				new Student(23, "Sri"), new Student(45, "Abhi"));
		jav8.sortStudentData(studends);
	}
}

class NameDescComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
}

class UsingJav8 {

	public void shortData(List<String> names) {
		Comparator<String> comp = (s1, s2) -> s2.compareTo(s1);
		Collections.sort(names, comp);
		System.out.println(names);
		names.sort(String::compareTo);
		System.out.println(names);
		Consumer<String> cons = System.out::println;
		names.forEach(cons);
		names.forEach(System.out::println);
		System.out.println("================1===============");
		Supplier<Student> s1 = ()->new Student();
		Student st1 = s1.get();
		System.out.println(st1);
		System.out.println("=====================2=============");
		Supplier<Student> s2 = Student::new;
		Student st2 = s2.get();
		System.out.println(st2);
	}

	public void sortStudentData(List<Student> studends) {
		Comparator<Student> comp = (s1, s2) -> s1.getSid() - s2.getSid();
		Collections.sort(studends, comp);
		studends.forEach(System.out::print);
		studends.sort((s1, s2) -> s1.getSid() - s2.getSid());
		studends.forEach(s -> System.out.println(s));
		studends.sort((Student s1, Student s2) -> s1.getSid() - s2.getSid());
		studends.forEach(System.out::println);
		Comparator<Student> scomp = comparing(Student::getSid);
		studends.sort(scomp);
		studends.forEach(System.out::println);
		studends.sort(comparing(Student::getSid));
		studends.forEach(System.out::println);
	}

}

class Student {
	private int sid;
	private String name;

	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
	}

	public Student() {
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name = " + name + "], ";
	}
}
