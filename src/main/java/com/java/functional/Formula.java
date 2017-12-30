package com.java.functional;

@FunctionalInterface
public interface Formula {

	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	default double square(int a) {
		return Math.sqrt(a);
	}
}
