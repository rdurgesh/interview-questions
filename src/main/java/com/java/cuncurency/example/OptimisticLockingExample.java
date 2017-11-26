package com.java.cuncurency.example;

import static com.java.cuncurency.example.ConcurrentUtils.sleep;
import static com.java.cuncurency.example.ConcurrentUtils.stop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class OptimisticLockingExample {

	static int count = 0;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		StampedLock lock = new StampedLock();

		executorService.submit(() -> {
			long stamp = lock.tryOptimisticRead();
			try {
				System.out.println("Optimistic lock valid: " + lock.validate(stamp));
				sleep(1);
				System.out.println("Optimistic lock valid: " + lock.validate(stamp));
				sleep(2);
				System.out.println("Optimistic lock valid: " + lock.validate(stamp));
			} finally {
				lock.unlock(stamp);
			}
		});

		executorService.submit(() -> {
			long stamp = lock.writeLock();
			try {
				System.out.println("write lock acquired");
				sleep(2);
			} finally {
				lock.unlock(stamp);
				System.out.println("write done");
			}
		});
		stop(executorService);

		// converting read lock into write lock

		ExecutorService executor = Executors.newFixedThreadPool(2);
		StampedLock stapedLock = new StampedLock();

		executor.submit(() -> {
			long stamp = stapedLock.readLock();
			try {
				if (count == 0) {
					stamp = stapedLock.tryConvertToWriteLock(stamp);
					if (stamp == 0L) {
						System.out.println("Could not convert to write lock");
						stamp = stapedLock.writeLock();
					}
					count = 23;
				}
				System.out.println(count);
			} finally {
				stapedLock.unlock(stamp);
			}
		});

		stop(executor);
	}

}
