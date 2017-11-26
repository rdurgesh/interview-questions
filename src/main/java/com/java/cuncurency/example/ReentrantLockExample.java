package com.java.cuncurency.example;

import static com.java.cuncurency.example.ConcurrentUtils.sleep;
import static com.java.cuncurency.example.ConcurrentUtils.stop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	ReentrantLock lock = new ReentrantLock();
	int count = 0;

	public void increment() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}

	public void executeMultipleThreadsSync() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		executorService.submit(() -> {
			lock.lock();
			try {
				sleep(1);
			} finally {
				lock.unlock();
			}
		});

		executorService.submit(() -> {
			System.out.println("Locked : " + lock.isLocked());
			System.out.println("Held by me: " + lock.isHeldByCurrentThread());
			boolean locked = lock.tryLock();
			System.out.println("Lock acquired: " + locked);
		});
		stop(executorService);
	}

	public static void main(String[] args) {
		ReentrantLockExample example = new ReentrantLockExample();
		example.executeMultipleThreadsSync();
	}
}
