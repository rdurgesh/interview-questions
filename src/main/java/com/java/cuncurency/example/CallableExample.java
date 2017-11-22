package com.java.cuncurency.example;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {
		Callable<Integer> task = () -> {
			TimeUnit.SECONDS.sleep(5);
			return 123;
		};
	}
}
