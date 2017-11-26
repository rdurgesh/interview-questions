package com.java.cuncurency.example;

import static com.java.cuncurency.example.ConcurrentUtils.sleep;
import static com.java.cuncurency.example.ConcurrentUtils.stop;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		StampedLock lock = new StampedLock();

		executorService.submit(() -> {
			long stamp = lock.writeLock();
			try {
				sleep(1);
				map.put("foo", "bar");
			} finally {
				lock.unlockWrite(stamp);
			}
		});

		Runnable readTask = () -> {
			long stamp = lock.readLock();
			try {
				System.out.println(map.get("foo"));
				sleep(1);
			} finally {
				lock.unlockRead(stamp);
			}
		};
		executorService.submit(readTask);
		executorService.submit(readTask);

		stop(executorService);
	}

}
