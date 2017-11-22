package com.java.interview.example;

import java.util.Arrays;

public class ArrayReverse {

	public static void main(String[] args) {
		ArrayReverse arrayReverse = new ArrayReverse();
		int[] array = { 1, 2, 3, 4, 5 };
		arrayReverse.reverseArray(array);
		arrayReverse.reverseArray(array, 3);
	}

	// reverse the entire given array
	public int[] reverseArray(int[] array) {

		int length = array.length;

		int[] reversedArray = new int[length];

		for (int i = 1; i <= length; i++) {
			reversedArray[i - 1] = array[length - i];
		}
		System.out.println(Arrays.toString(reversedArray));
		
		return reversedArray;
	}

	// reverse the given array till given index
	public int[] reverseArray(int[] array, int index) {

		int length = array.length;

		int[] reversedArray = new int[length];

		for (int i = 1; i <= index; i++) {
			reversedArray[i - 1] = array[index - i];
		}
		int remSize = length - index;
		for (int i = 0; i < remSize; i++) {
			reversedArray[index + i] = array[index + i];
		}
		System.out.println(Arrays.toString(reversedArray));
		
		return reversedArray;
	}
}
