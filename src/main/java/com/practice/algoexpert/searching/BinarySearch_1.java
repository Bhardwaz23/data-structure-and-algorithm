package com.practice.algoexpert.searching;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/BinarySearch.png" />
 *
 */
public class BinarySearch_1 {

	public static void main(String[] args) {
		int result = binarySearch(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33);
		System.out.println(result);

	}

	// O(log(n)) time | O(1) space

	public static int binarySearch(int[] array, int target) {

		return binarySearch(array, target, 0, array.length - 1);

	}

	public static int binarySearch(int[] array, int target, int left, int right) {

		while (left <= right) {

			int middle = (left + right) / 2;

			int potentialMatch = array[middle];

			if (target == potentialMatch) {

				return middle;

			} else if (target < potentialMatch) {

				right = middle - 1;

			} else {

				left = middle + 1;

			}

		}

		return -1;

	}
}
