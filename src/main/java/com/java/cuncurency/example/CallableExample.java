package com.java.cuncurency.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {
		Callable<Integer> task = () -> {
			TimeUnit.SECONDS.sleep(5);
			return 123;
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = executorService.submit(task);

		System.out.println("Future is done ? " + future.isDone());

		try {
			Integer result = future.get();
			System.out.print("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
