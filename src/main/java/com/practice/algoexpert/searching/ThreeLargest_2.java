package com.practice.algoexpert.searching;

public class ThreeLargest_2 {

	public static void main(String[] args) {
		int[] result = findThreeLargestNumbers(new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 });
		for (int r : result) {
			System.out.println(r + "\t");
		}

	}

	// O(n) time | O(1) space

	public static int[] findThreeLargestNumbers(int[] array) {
		int[] threeLargest = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };

		for (int num : array) {

			updateLargest(threeLargest, num);

		}

		return threeLargest;

	}

	public static void updateLargest(int[] threeLargest, int num) {

		if (num > threeLargest[2]) {

			shiftAndUpdate(threeLargest, num, 2);

		} else if (num > threeLargest[1]) {

			shiftAndUpdate(threeLargest, num, 1);

		} else if (num > threeLargest[0]) {

			shiftAndUpdate(threeLargest, num, 0);

		}

	}

	public static void shiftAndUpdate(int[] array, int num, int idx) {

		for (int i = 0; i <= idx; i++) {

			if (i == idx) {

				array[i] = num;

			} else {

				array[i] = array[i + 1];

			}

		}

	}

}
