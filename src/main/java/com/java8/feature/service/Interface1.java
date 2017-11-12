package com.java8.feature.service;

public interface Interface1 {

	public String show();

	public String display();

	default String process() {
		System.out.println("interface level implementation of default process method");
		return "interface level implementation of default process method";
	}

	default String execute() {
		System.out.println("interface level implementation of default execute method");
		return "interface level implementation of default execute method";
	}

	default Number getNumber() {
		System.out.println("Get number of interface1");
		return 42;
	}
}
