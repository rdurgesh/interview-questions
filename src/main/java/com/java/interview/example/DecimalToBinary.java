package com.java.interview.example;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int counter = 0, max = 0;
		while (n > 0) {
			counter = ++counter * (n % 2);
			max = Math.max(counter, max);
			n /= 2;
		}
		System.out.println(max);
	}
}
