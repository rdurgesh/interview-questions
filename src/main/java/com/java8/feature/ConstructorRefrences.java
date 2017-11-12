package com.java8.feature;

import java.util.function.BiFunction;

public class ConstructorRefrences {
	public static void main(String[] args) {
		System.out.println("================Using custom Inteface=====================");
		CustomInterface<StudentDefault> cust = StudentDefault::new;
		StudentDefault st = cust.get(12, "Manish");
		System.out.println(st);
		CustomInterface<Employee> ecust = Employee::new;
		Employee emp = ecust.get(99, "Ranjan");
		System.out.println(emp);

		System.out.println("=================Using BiFunction========================");
		BiFunction<Integer, String, StudentDefault> func = StudentDefault::new;
		StudentDefault std = func.apply(12, "Manish");
		System.out.println(std);
		BiFunction<Integer, String, Employee> func2 = Employee::new;
		Employee emp2 = func2.apply(99, "Ranjan");
		System.out.println(emp2);
	}
}

interface CustomInterface<T> {
	T get(int value, String data);
}

class StudentDefault {

	private int sid;

	private String sname;

	public StudentDefault(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
}

class Employee {

	private int eid;

	private String ename;

	public Employee(int eid, String ename) {
		this.eid = eid;
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
}
