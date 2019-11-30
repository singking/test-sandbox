package com.singking.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find integers in an array that have exactly two occurrences
 *
 */
public class ArrayIndexs {

	/**
	 * Returns a List of integers that occurs only twice in the integer array
	 * passed
	 * 
	 * @return
	 */
	public static List<Integer> findDoubleOccurrences(final int[] integerList) {

		assert integerList.length > 2;

		List<Integer> occurrencesList = new ArrayList<Integer>();

		// array is sorted so occurrences can be determined efficiently
		Arrays.sort(integerList);

		// iterate the integer list one integer at a time
		int intMinus1 = integerList[0];
		int occurrences = 1;
		for (int i = 1; i < integerList.length; i++) {

			// test if the current integer and the previous integer are equal
			if (integerList[i] != intMinus1) {

				// new identical number sequence so process last sequence
				if (occurrences == 2) {
					occurrencesList.add(intMinus1);
					System.out.println("\ndouble=" + intMinus1);
				}

				// reset for new sequence detection
				occurrences = 1;
			}

			// same integers found so increment the number of occurrences found
			if (integerList[i] == intMinus1) {
				occurrences++;
			}

			// prepare for next iteration by setting the previous integer
			// to the current one
			intMinus1 = integerList[i];
		}

		if (integerList[integerList.length - 1] == intMinus1) {
			// new sequence so process last sequence
			if (occurrences == 2) {
				occurrencesList.add(intMinus1);
			}
		}

		return occurrencesList;
	}

	public static void main(String[] args) {
		int[] integerList = { 8, 7, 2, 4, 1, 5, 1, 7, 3, 9, 99, 99, 3, 0, 8, 6, 4, 7, 2, 5, 4, 5, 6, 2, 100, 100 };
		// int [] integerList = {1,2,3,4,5,5,6,7,8,9};

		for (int i = 0; i < integerList.length; i++) {
			System.out.print(integerList[i] + ", ");
		}

		List<Integer> occurrencesList = findDoubleOccurrences(integerList);
		System.out.println("\n");
		System.out.println("Double Occurences Follow");
		System.out.println("----------");
		for (int i = 0; i < occurrencesList.size(); i++) {
			System.out.print(occurrencesList.get(i) + ", ");
		}

	}

}
