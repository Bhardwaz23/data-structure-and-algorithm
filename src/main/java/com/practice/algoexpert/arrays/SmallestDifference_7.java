package com.practice.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/SmallestDifference.png" />
 *
 */
public class SmallestDifference_7 {

	public static void main(String[] args) {
		int[] result = smallestDifference(new int[] { -1, 5, 10, 20, 28, 3 }, new int[] { 26, 134, 135, 15, 17 });
		System.out.print("[\t");
		for (int i = 0; i < result.length; i++) {

			System.out.print(result[i] + "\t");
		}
		System.out.print("]\t");

	}

	// O(nlog(n) + mlog(m)) time | O(1) space

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);

		int idxOne = 0;

		int idxTwo = 0;

		int smallest = Integer.MAX_VALUE;

		int current = Integer.MAX_VALUE;

		int[] smallestPair = new int[2];

		while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {

			int firstNum = arrayOne[idxOne];

			int secondNum = arrayTwo[idxTwo];

			if (firstNum < secondNum) {

				current = secondNum - firstNum;

				idxOne++;

			} else if (secondNum < firstNum) {

				current = firstNum - secondNum;

				idxTwo++;

			} else {

				return new int[] { firstNum, secondNum };

			}

			if (smallest > current) {

				smallest = current;

				smallestPair = new int[] { firstNum, secondNum };

			}

		}

		return smallestPair;

	}

}
