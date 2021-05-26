package com.practice.algoexpert.sorting;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/InsertionSort.png" />
 *
 */
public class InsertionSort_2 {

	public static void main(String[] args) {
		int[] result = insertionSort(new int[] { 8, 5, 2, 9, 5, 6, 3 });
		for (int i : result) {
			System.out.print(i + "\t");
		}

	}

	// Best: O(n) time | O(1) space

	// Average: O(n^2) time | O(1) space

	// Worst: O(n^2) time | O(1) space

	public static int[] insertionSort(int[] array) {

		if (array.length == 0) {

			return new int[] {};

		}

		for (int i = 1; i < array.length; i++) {

			int j = i;

			while (j > 0 && array[j] < array[j - 1]) {

				swap(j, j - 1, array);

				j -= 1;

			}

		}

		return array;

	}

	public static void swap(int i, int j, int[] array) {

		int temp = array[j];

		array[j] = array[i];

		array[i] = temp;

	}
}
