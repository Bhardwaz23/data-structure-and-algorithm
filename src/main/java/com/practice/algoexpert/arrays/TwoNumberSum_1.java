package com.practice.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/TwoNumberSum.png" />
 *
 */
public class TwoNumberSum_1 {

	public static void main(String[] args) {
		int[] array = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum = 10;
		int[] result = twoNumberSum_sol2(array, targetSum);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}
	}

	/**
	 * O(n2) time | O(1) space
	 * 
	 * @param array
	 * @param targetSum
	 * @return
	 */
	public static int[] twoNumberSum_sol1(int[] array, int targetSum) {

		for (int i = 0; i < array.length - 1; i++) {
			int firstElement = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (targetSum == firstElement + array[j]) {
					return new int[] { firstElement, array[j] };
				}
			}
		}

		return new int[0];

	}

	/**
	 * O(n) time | O(n) space
	 * 
	 * @param array
	 * @param targetSum
	 * @return
	 */
	public static int[] twoNumberSum_sol2(int[] array, int targetSum) {

		Set<Integer> nums = new HashSet<Integer>();
		for (int num : array) {
			int potentialMatch = targetSum - num;
			if (nums.contains(potentialMatch)) {
				return new int[] { num, potentialMatch };
			} else {
				nums.add(num);
			}
		}

		return new int[0];

	}

	/**
	 * O(nlog(n) time | O(1) space
	 * 
	 * @param array
	 * @param targetSum
	 * @return
	 */
	public static int[] twoNumberSum_sol3(int[] array, int targetSum) {

		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		
		while (left < right) {
			int currentSum = array[left] + array[right];
			
			if (currentSum == targetSum) {
				return new int[] { array[left], array[right] };
			} else if (currentSum < targetSum) {
				left++;
			} else if (currentSum > targetSum) {
				right--;
			}

		}

		return new int[0];

	}

}
