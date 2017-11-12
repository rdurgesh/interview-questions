package com.java.map.example;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable {

	private Map<Integer, Product> intToProduct = new HashMap<>();

	@Override
	public Product lookupById(final int id) {
		return intToProduct.get(id);
	}

	@Override
	public void addProduct(final Product productToAdd) {
		final int id = productToAdd.getId();
		if (intToProduct.containsKey(id)) {
			throw new IllegalArgumentException("Unable to add product, duplicate id for" + productToAdd);
		}
		intToProduct.put(productToAdd.getId(), productToAdd);
	}

	@Override
	public void clear() {
		intToProduct.clear();
	}

}
