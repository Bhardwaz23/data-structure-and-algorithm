package com.practice.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/MoveElementToEnd.png" />
 *
 */
public class MoveElementToEnd_8 {

	public static void main(String[] args) {
		List<Integer> result = moveElementToEnd(new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2)), 2);

		for (Integer num : result) {
			System.out.print(num + "\t");
		}

	}

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

		int i = 0;

		int j = array.size() - 1;
		while (i < j) {

			while (i < j && array.get(j) == toMove)
				j--;

			if (array.get(i) == toMove)
				swap(i, j, array);

			i++;

		}

		return array;

	}

	public static void swap(int i, int j, List<Integer> array) {

		int temp = array.get(j);

		array.set(j, array.get(i));

		array.set(i, temp);

	}
}