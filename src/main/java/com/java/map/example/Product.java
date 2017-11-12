package com.java.map.example;

import java.util.Comparator;

public class Product {

	private final int id;

	private final String name;

	private final int weight;

	public Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);

	public Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);

	public Product(final int id, final String name, final int weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}
}
