package com.java8.feature.service;

public interface Interface3 extends Interface1 {

	default String getData() {
		return "Interface3 getData method";
	}
}
