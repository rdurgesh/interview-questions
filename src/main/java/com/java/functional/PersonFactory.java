package com.java.functional;

public interface PersonFactory<P extends Person> {

	P create(String firstName, String lastName);
}
