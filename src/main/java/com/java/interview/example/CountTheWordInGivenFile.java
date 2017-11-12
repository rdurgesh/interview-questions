package com.java.interview.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountTheWordInGivenFile {

	public static void main(String[] args) {
		final String FILENAME = "E:\\Backups\\filename.txt";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
