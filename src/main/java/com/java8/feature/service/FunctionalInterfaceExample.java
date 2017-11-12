package com.java8.feature.service;

@FunctionalInterface
public interface FunctionalInterfaceExample {
	void show();
	//void display(){}//invalid
	default void display(){}
	default void execute(){}
	static void process() {}
	static void processExecute() {}
	//default static void processExecutee() {}//invalid
}
