package com.java8.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SequentialVsParallelStreams {
	public static void main(String[] args) {
		long startNanoSec = 0;
		long endNanoSec = 0;
		int maxElements = 9992999;

		List<Integer> numberAr = new ArrayList<Integer>();
		for (int i = 0; i < maxElements; i++) {
			numberAr.add(i);
		}
		System.out.println("No of elements to be counted using streams " + maxElements);

		Stream<Integer> sequentialStream = numberAr.stream();
		startNanoSec = System.nanoTime();
		System.out.println("\n1. No of elements counted using sequential streams = " + sequentialStream.count());
		endNanoSec = System.nanoTime();
		System.out.println("Time taken to count elements using sequential streams = " + (endNanoSec - startNanoSec) + " NanoSeconds");

		Stream<Integer> parallelStream = numberAr.parallelStream();
		// parallelStream() method - Returns parallel Stream with this collection
		startNanoSec = System.nanoTime();
		System.out.println("\n2. No of elements counted using PARALLEL streams = " + parallelStream.count());
		endNanoSec = System.nanoTime();
		System.out.print("Time taken to count elements using PARALLEL streams = " + (endNanoSec - startNanoSec) + " NanoSeconds");
	}
}
