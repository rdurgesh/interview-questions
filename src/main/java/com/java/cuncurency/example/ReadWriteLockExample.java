package com.java.cuncurency.example;

import static com.java.cuncurency.example.ConcurrentUtils.sleep;
import static com.java.cuncurency.example.ConcurrentUtils.stop;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	public void executeMultipleThreadsSync() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		executorService.submit(() -> {
			lock.writeLock().lock();
			try {
				sleep(1);
				map.put("foo", "bar");
			} finally {
				lock.writeLock().unlock();
			}
		});

		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println(map.get("foo"));
				sleep(1);
			} finally {
				lock.readLock().unlock();
			}
		};

		executorService.submit(readTask);
		executorService.submit(readTask);

		stop(executorService);
	}

	public static void main(String[] args) {
		ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();
		readWriteLockExample.executeMultipleThreadsSync();
	}
}
