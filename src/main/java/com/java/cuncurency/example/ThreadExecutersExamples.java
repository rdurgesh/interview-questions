package com.java.cuncurency.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutersExamples {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});

		executorService.shutdown();
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
			e.printStackTrace();
		} finally {
			if (!executorService.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executorService.shutdownNow();
			System.out.println("shutdown finished");
		}
	}
}
