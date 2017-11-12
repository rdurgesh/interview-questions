package com.java8.feature;

import com.java8.feature.service.Interface3;
import com.java8.feature.service.Interface4;

public class ParentClass implements Interface3, Interface4 {

	public String process() {
		System.out.println("Parent class process method");
		return "Parent class process method";
	}

	@Override
	public String show() {
		return "Parent class show method";
	}

	@Override
	public String display() {
		return "Parent class display method";
	}

	@Override
	public String getData() {
		return Interface3.super.getData();
	}
}
