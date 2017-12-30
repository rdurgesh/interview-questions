package com.java.functional;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
