package com.java8.feature;

import com.java8.feature.service.Interface1;

public class Hello implements Interface1 {

	private int var = 10;

	@Override
	public String show() {
		System.out.println("Show method of Hello Class");
		return "Show method of Hello Class";
	}

	@Override
	public String display() {
		System.out.println("Display method of Hello Class");
		return "Display method of Hello Class";
	}

	public void testThisParameter(Hello this,String str) {
		System.out.println("Local" + var);
		System.out.println("Instance" + this.var);
		Hello hello = new Hello();
		hello.testThisParameter(str);
	}
}
