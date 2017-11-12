package com.java8.feature.service;

public interface Interface2 extends Interface1 {
	
	default Integer getNumber() {
		System.out.println("Get number of Inteface2");
		return 10;
	}

}
