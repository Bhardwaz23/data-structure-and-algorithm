package com.practice.algoexpert.strings;

/**
 * <b>Given a string str, the task is to find whether the string is a palindrome
 * or not in Java without using library methods.</b><br>
 * 
 * @author nishant.bhardwaz<br>
 * 
 */
public class Palindrome_1 {

	public static void main(String[] args) {
		System.out.println(isPalindrome_Sol2("abcba"));

	}

	/**
	 * 
	 * 
	 * <b>Why does the first solution run in O(n^2) time when it only uses a single
	 * for loop?</b><br>
	 * 
	 * <i>At each iteration in the for loop, the first solution adds a character to
	 * the reversedString. In most languages where strings are immutable, adding a
	 * character to a string involves re-creating the entire string, which in turn
	 * involves iterating through every character in the string (an O(n)-time
	 * operation). <br>
	 * This, the first solution has us perform an O(n)-time operation at each<br>
	 * iteration in the for loop, leading to an O(n^2)-time algorithm overall.</i>
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isPalindrome_Sol1(String str) {
		StringBuilder reversedString = new StringBuilder("");
		if (str == null) {
			return false;
		}

		for (int i = str.length() - 1; i >= 0; i--) {
			reversedString.append(str.charAt(i));
		}

		return (str.equals(reversedString.toString()) ? true : false);
	}

	/**
	 * O(n) time | O(n) space
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isPalindrome_Sol2(String str) {
		StringBuilder reversedString = new StringBuilder("");
		if (str == null) {
			return false;
		}

		for (int i = str.length() - 1; i >= 0; i--) {
			reversedString.append(str.charAt(i));
		}

		return (str.equals(reversedString.toString()) ? true : false);
	}

	/**
	 * O(n) time | O(1) space
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isPalindrome_Sol3(String str) {

		int leftIdx = 0;

		int rightIdx = str.length() - 1;

		while (leftIdx < rightIdx) {

			if (str.charAt(leftIdx) != str.charAt(rightIdx)) {

				return false;

			}

			leftIdx++;

			rightIdx--;

		}

		return true;

	}

}
