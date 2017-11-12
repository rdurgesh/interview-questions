package com.java.interview.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {

	public static void main(String[] args) {

		int n, temp;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter no. of elements you want in array:");
		n = scanner.nextInt();
		int a[] = new int[n];

		System.out.println("Enter all the elements:");
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.print("Ascending Order:");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.print(a[n - 1]);

		int[] arr = { 3, 4, 7, 5, 6, 2, 1 };
		Arrays.sort(arr);
		System.out.println(findNumber(arr, 7));
		System.out.println(Arrays.binarySearch(arr, 7));
	}

	static String findNumber(int[] arr, int k) {
		boolean result = Arrays.stream(arr).anyMatch(x -> x == k);
		if (result) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
