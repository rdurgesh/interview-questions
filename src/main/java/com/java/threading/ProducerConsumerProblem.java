package com.java.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		Runnable producer = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread producer ==> " + threadName);
			try {
				queue.put("1");
				Thread.sleep(1000);
				queue.put("2");
				Thread.sleep(1000);
				queue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable consumer = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread consumer ==> " + threadName);
			try {
				System.out.println(queue.take());
				System.out.println(queue.take());
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		new Thread(producer).start();
		new Thread(consumer).start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
