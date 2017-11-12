package com.java8.feature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNameUsingReflection {

	void show(int sid, String name, String... email) {

	}

	void display(long val, boolean valid, char choice) {

	}

	public static void main(String[] args) {

		Class<ParameterNameUsingReflection> cl = ParameterNameUsingReflection.class;
		Method ms[] = cl.getDeclaredMethods();
		for (Method m : ms) {
			String nm = m.getName();
			System.out.println("\nMethod: " + nm);
			Parameter params[] = m.getParameters();
			for (Parameter pr : params) {
				boolean pre = pr.isNamePresent();
				String pnm = pr.getName();
				boolean isVarargs = pr.isVarArgs();
				String type = pr.getType().getName();
				System.out.println(pre + "\n" + pnm + "\t" + type + "\t" + isVarargs);
			}
			System.out.println();
		}
	}
}
