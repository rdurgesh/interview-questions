package com.java8.feature;

import java.util.ArrayList;
import java.util.List;

public class ShortCircuitingOperations {
	public static void main(String[] args) {
		 List<String> stringList = new ArrayList<>();
         stringList.add("a");    
         stringList.add("b");    
         stringList.add("a");    
         // In one line display all distinct records in stream
         System.out.println("\nUse stream for finding distinct elements and and display");
         stringList.parallelStream().distinct().forEach(System.out::println);
	}
}
