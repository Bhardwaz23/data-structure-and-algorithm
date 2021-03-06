package com.practice.algoexpert.sorting;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/BubbleSort.png" />
 *
 */
public class BubbleSort_1 {

	public static void main(String[] args) {
		int[] result = bubbleSort(new int[] { 8, 5, 2, 9, 5, 6, 3 });
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	// Best: O(n) time | O(1) space

	// Average: O(n^2) time | O(1) space

	// Worst: O(n^2) time | O(1) space

	public static int[] bubbleSort(int[] array) {

		if (array.length == 0) {

			return new int[] {};

		}

		boolean isSorted = false;

		int counter = 0;

		while (!isSorted) {

			isSorted = true;

			for (int i = 0; i < array.length - 1 - counter; i++) {

				if (array[i] > array[i + 1]) {

					swap(i, i + 1, array);

					isSorted = false;

				}

			}

			counter++;

		}

		return array;

	}

	public static void swap(int i, int j, int[] array) {

		int temp = array[j];

		array[j] = array[i];

		array[i] = temp;

	}
}
