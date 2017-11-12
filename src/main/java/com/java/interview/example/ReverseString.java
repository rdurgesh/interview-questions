package com.java.interview.example;

public class ReverseString {
	public static void main(String[] args) {
		String message = "ABCDEF";
		StringBuffer buffer = new StringBuffer(message);
		System.out.println(buffer.reverse());

		char[] chars = message.toCharArray();
		int length = chars.length;
		char[] temp = new char[length];
		for (int i = 1; i <= length; i++) {
			temp[i - 1] = chars[length - i];
		}
		System.out.println(String.valueOf(temp));
	}
}
