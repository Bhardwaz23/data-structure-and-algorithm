package com.practice.gfg.array.longestConsecutiveSequence;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of integers, find the length of the longest sub-sequence such
 * that elements in the subsequence are consecutive integers, the consecutive
 * numbers can be in any order.
 * 
 * @author nishant.bhardwaz
 * @see https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 *
 */
public class NativeApproach_1 {
	static int findLongestConseqSubseq(int arr[], int n) {

		// Sort the array
		Arrays.sort(arr);

		int ans = 0, count = 0;

		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(arr[0]);

		// Insert repeated elements
		// only once in the vector
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[i - 1])
				v.add(arr[i]);
		}

		// Find the maximum length
		// by traversing the array
		for (int i = 0; i < v.size(); i++) {

			// Check if the current element is
			// equal to previous element +1
			if (i > 0 && v.get(i) == v.get(i - 1) + 1)
				count++;
			else
				count = 1;

			// Update the maximum
			ans = Math.max(ans, count);
		}
		return ans;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;

		System.out.println("Length of the Longest " + "contiguous subsequence is " + findLongestConseqSubseq(arr, n));
	}
}
