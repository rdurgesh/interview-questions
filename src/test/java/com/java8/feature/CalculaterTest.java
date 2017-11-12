package com.java8.feature;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.java.dque.example.Calculator;

public class CalculaterTest {

	@Test
	public void shouldDoAddOperation() {
		Calculator calculator = new Calculator();
		assertSame(5, calculator.evaluate("2 + 3"));
	}

	@Test
	public void shouldDoSubstractOperation() {
		Calculator calculator = new Calculator();
		assertSame(2, calculator.evaluate("5 - 3"));
	}
}
