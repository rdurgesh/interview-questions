package com.java.dque.example;

import static java.lang.Integer.parseInt;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {

	public int evaluate(final String input) {
		final Deque<String> stack = new ArrayDeque<>();
		final String[] tokens = input.split(" ");
		Arrays.stream(tokens).forEach(token -> stack.add(token));
		while (stack.size() > 1) {
			final int left = parseInt(stack.pop());
			final String operator = stack.pop();
			final int right = parseInt(stack.pop());

			int result = 0;
			switch (operator) {

			case "+":
				result = left + right;
				break;

			case "-":
				result = left - right;

			default:
				break;
			}
			stack.push(String.valueOf(result));
		}
		return parseInt(stack.pop());
	}
}
