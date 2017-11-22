package com.java.singleton.example;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton instance;

	private int value;

	/* Private Constructor prevents any
	 * other class from instantiating
	 */
	private Singleton() {
	}

	/* Restrict cloning of object */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return getInstance();
	}

	public static synchronized Singleton getInstance() {
		/* Lazy initialization, creating object on first use */
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	public void display() {
		System.out.println("Hurray! I am display from Singleton!");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
