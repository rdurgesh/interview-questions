package com.java8.feature.service;

public interface Interface4 extends Interface1 {

	default String getData() {
		return "Interface4 getData method";
	}
}
