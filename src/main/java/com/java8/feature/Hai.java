package com.java8.feature;

import com.java8.feature.service.Interface1;

public class Hai implements Interface1 {

	@Override
	public String show() {
		System.out.println("Show method of Hai Class");
		return "Show method of Hai Class";

	}

	@Override
	public String display() {
		System.out.println("Display method of Hai Class");
		return "Display method of Hai Class";
	}

	@Override
	public String process() {
		System.out.println("Hai class implementation of default process method");
		return "Hai class implementation of default process method";
	}

	@Override
	public String execute() {
		return Interface1.super.execute();
	}
}
