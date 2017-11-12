package com.java.map.example;

public interface ProductLookupTable {

	public Product lookupById(int id);

	public void addProduct(Product product);

	public void clear();
}
