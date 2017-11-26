package com.java.singleton.example;

import static org.junit.Assert.assertSame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void shouldHaveOnlyOneInstance() {
		Singleton object1 = Singleton.getInstance();
		Singleton object2 = Singleton.getInstance();
		assertSame(object1, object2);
	}

	@Test
	public void shouldReturnSameObjectInCaseOfSerializationAlso() {
		// getting singleton instance
		Singleton instanceOne = Singleton.getInstance();
		instanceOne.setValue(10);

		try {
			// Serialize to a file
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("E:\\Backups\\filename.txt"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setValue(20);

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream("E:\\Backups\\filename.txt"));
			Singleton instanceTwo = (Singleton) in.readObject();
			in.close();

			System.out.println("Instance One Value= " + instanceOne.getValue());
			System.out.println("Instance Two Value= " + instanceTwo.getValue());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSingletonInMultiThreading() {
		Runnable task1 = () -> {
			Singleton instanceOne = Singleton.getInstance();
			System.out.println("Instance One Value= " + instanceOne.getValue());
		};
		Runnable task2 = () -> {
			Singleton instancetwo = Singleton.getInstance();
			System.out.println("Instance One Value= " + instancetwo.getValue());
		};

		new Thread(task1).start();
		new Thread(task2).start();
	}
}
