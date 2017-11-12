package com.java.interview.example;

import java.util.Scanner;

public class ArrayRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = in.nextInt();
		System.out.println("Enter the number of rotations:");
		int d = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the element of array:");
			int index = (i + n - d) % n;
			array[index] = in.nextInt();
			System.out.println("Added on index: " + index);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
