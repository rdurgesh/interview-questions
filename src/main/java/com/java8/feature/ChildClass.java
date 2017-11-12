package com.java8.feature;

import com.java8.feature.service.Interface1;
import com.java8.feature.service.Interface2;

public class ChildClass extends ParentClass implements Interface1, Interface2 {

	@Override
	public String show() {
		return "Child class show method";
	}

	@Override
	public String display() {
		return "Child class display method";
	}
}
