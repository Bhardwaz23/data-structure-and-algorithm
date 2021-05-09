package com.practice.algoexpert.arrays;

import java.util.Arrays;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/NonConstructableChange.png" />
 *
 */
public class NonConstructableChange_5 {

	public static void main(String[] args) {
		System.out.println(nonConstructibleChange(new int[] { 5, 7, 1, 1, 2, 3, 22 }));

	}

	// O(nlogn) time | O(1) space - where n is the number of coins

	public static int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins);
		int currentChangeCreated = 0;

		for (int coin : coins) {

			if (coin > currentChangeCreated + 1) {

				return currentChangeCreated + 1;

			}

			currentChangeCreated += coin;

		}

		return currentChangeCreated + 1;

	}

}
