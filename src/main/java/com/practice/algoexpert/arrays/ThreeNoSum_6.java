package com.practice.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/ThreeNoSum.png" />
 *
 */
public class ThreeNoSum_6 {

	public static void main(String[] args) {

		List<Integer[]> result = threeNumberSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0);

		for (Integer[] array : result) {
			System.out.print("["+"\t");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + "\t");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	// O(n^2) time | O(n) space

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

		Arrays.sort(array);
		List<Integer[]> triplets = new ArrayList<Integer[]>();

		for (int i = 0; i < array.length - 2; i++) {

			int left = i + 1;

			int right = array.length - 1;

			while (left < right) {

				int currentSum = array[i] + array[left] + array[right];

				if (currentSum == targetSum) {

					Integer[] newTriplet = { array[i], array[left], array[right] };

					triplets.add(newTriplet);

					left++;

					right--;

				} else if (currentSum < targetSum) {

					left++;

				} else if (currentSum > targetSum) {

					right--;

				}

			}

		}

		return triplets;

	}

}
