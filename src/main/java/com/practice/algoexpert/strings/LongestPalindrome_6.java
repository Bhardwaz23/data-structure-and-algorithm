package com.practice.algoexpert.strings;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/LongestPalindrome.png" />
 *
 */
public class LongestPalindrome_6 {

	public static void main(String[] args) {

		System.out.println(longestPalindromicSubstring("abaxyzzyxf"));

	}

	// O(n^2) time | O(n) space

	public static String longestPalindromicSubstring(String str) {

		int[] currentLongest = { 0, 1 };

		for (int i = 1; i < str.length(); i++) {

			int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);

			int[] even = getLongestPalindromeFrom(str, i - 1, i);

			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

			currentLongest =

					currentLongest[1] - currentLongest[0] > longest[1] - longest[0]

							? currentLongest

							: longest;

		}

		return str.substring(currentLongest[0], currentLongest[1]);

	}

	public static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {

		while (leftIdx >= 0 && rightIdx < str.length()) {

			if (str.charAt(leftIdx) != str.charAt(rightIdx)) {

				break;

			}

			leftIdx--;

			rightIdx++;

		}

		return new int[] { leftIdx + 1, rightIdx };

	}
}
