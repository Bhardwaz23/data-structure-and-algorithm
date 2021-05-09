package com.practice.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/SortedSquareArray.png" />
 *
 */
public class SortedSquareArray_3 {

	public static void main(String[] args) {
		int[] response = sortedSquaredArray_1(new int[] { -1, -2 });
		for (int i = 0; i < response.length; i++) {
			System.out.print(response[i] + "\t");
		}
	}

	/**
	 * @param array
	 * @return
	 */
	public static int[] sortedSquaredArray_1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];
		}
		Arrays.sort(array);
		return array;
	}

	public static int[] sortedSquaredArray_2(int[] array) {

		int[] sortedSquares = new int[array.length];

		int smallerValueIdx = 0;

		int largerValueIdx = array.length - 1;

		for (int idx = array.length - 1; idx >= 0; idx--) {

			int smallerValue = array[smallerValueIdx];

			int largerValue = array[largerValueIdx];

			if (Math.abs(smallerValue) > Math.abs(largerValue)) {

				sortedSquares[idx] = smallerValue * smallerValue;

				smallerValueIdx++;

			} else {

				sortedSquares[idx] = largerValue * largerValue;

				largerValueIdx--;

			}

		}

		return sortedSquares;
	}
}
