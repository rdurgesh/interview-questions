package com.java.cuncurency.example;

import static com.java.cuncurency.example.ConcurrentUtils.stop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedLocksExamples {

	private int count = 0;

	private volatile int countSync = 0;

	public void increment() {
		count = count + 1;
	}

	public synchronized void syncIncrement() {
		countSync = countSync + 1;
	}

	public void executeMultipleThreads() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
		stop(executor);
		System.out.println(count); // 9965
	}

	public void executeMultipleThreadsSync() {
		/*
		 * Fixing the above race condition issue
		 */
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000).forEach(i -> executor.submit(this::syncIncrement));
		stop(executor);
		System.out.println(countSync);
	}

	public static void main(String[] args) {
		SynchronizedLocksExamples examples = new SynchronizedLocksExamples();
		examples.executeMultipleThreads();
		examples.executeMultipleThreadsSync();
	}

}
