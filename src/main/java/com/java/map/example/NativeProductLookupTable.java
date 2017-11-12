package com.java.map.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NativeProductLookupTable implements ProductLookupTable {

	private List<Product> products = new ArrayList<>();

	@Override
	public Product lookupById(final int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void addProduct(Product productToAdd) {
		Predicate<Product> predicate = product -> product.getId() == productToAdd.getId();
		products.forEach(product -> {
			if (predicate.test(product)) {
				throw new IllegalArgumentException("Unable to add product, duplicate id for" + productToAdd);
			}
		});
		products.add(productToAdd);
	}

	@Override
	public void clear() {
		products.clear();
	}
}
