package com.practice.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/ValidateSequence.png" />
 *
 */
public class ValidateSequence_2 {

	public static void main(String[] args) {
		System.out.println(isValidSubsequence_1(new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10)),
				new ArrayList<Integer>(Arrays.asList(1, 6, -1, 10))));

	}

	/**
	 * O(n) time | O(1) space
	 * 
	 * @param array
	 * @param sequence
	 * @return
	 */
	public static boolean isValidSubsequence_1(List<Integer> array, List<Integer> sequence) {

		int arrayIndex = 0;
		int seqIndex = 0;
		while (arrayIndex < array.size() && seqIndex < sequence.size()) {
			if (array.get(arrayIndex).equals(sequence.get(seqIndex))) {
				seqIndex++;
			}
			arrayIndex++;
		}

		return seqIndex == sequence.size();
	}

}
