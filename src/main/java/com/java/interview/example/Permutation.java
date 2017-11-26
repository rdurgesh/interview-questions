package com.java.interview.example;

public class Permutation {

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		String str = "ABC";
		int length = str.length();
		permutation.permute(str, 0, length - 1);
	}

	public void permute(String str, int l, int n) {
		if (l == n) {
			System.out.println(str);
		} else {
			for (int i = l; i <= n; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, n);
				str = swap(str, l, i);
			}
		}
	}

	private String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
