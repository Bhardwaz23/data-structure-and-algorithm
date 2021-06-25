package com.practice.algoexpert.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiverSize_4 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 0 } };
		List<Integer> result = riverSizes(matrix);

		result.forEach(i -> System.out.print(i + "\t"));
		

	}

	public static List<Integer> riverSizes(int[][] matrix) {
		int[][] matrixOriginal = matrix;
		ArrayList<Integer> result = new ArrayList<Integer>();

		int xIdx = 0;

		int yIdx = 0;

		while (xIdx < matrix.length && yIdx < matrix[xIdx].length) {

			if (matrix[xIdx][yIdx] == 1) {

				int countRecved = findRiver(matrix, xIdx, yIdx);
				if (countRecved > 0) {
					result.add(countRecved);
				}

			}

			if (yIdx == matrix[xIdx].length - 1 && xIdx != matrix.length - 1) {
				yIdx = 0;

				xIdx++;

			} else {

				yIdx++;

			}

			if (xIdx == matrix.length - 1 && yIdx == matrix[xIdx].length - 1) {
				break;
			}

		}

		return result;

	}

	private static int findRiver(int[][] matrix, int xIdx, int yIdx) {

		boolean rightCheck = riverFoundAtRight(matrix, xIdx, yIdx);
		boolean downCheck = riverFoundAtDown(matrix, xIdx, yIdx);

		int totalRiverFound = 1;
		matrix[xIdx][yIdx] = -1;

		if (rightCheck) {
			while (rightCheck) {
				int xTemp = xIdx;
				while (downCheck) {
					matrix[xTemp][yIdx] = -1;
					xTemp = xTemp + 1;

					downCheck = riverFoundAtDown(matrix, xTemp, yIdx);
					totalRiverFound++;
				}
				matrix[xIdx][yIdx] = -1;
				yIdx = yIdx + 1;
				totalRiverFound++;
				rightCheck = riverFoundAtRight(matrix, xIdx, yIdx);
				downCheck = riverFoundAtDown(matrix, xTemp, yIdx);

			}
		} else if (downCheck) {
			int xTemp = xIdx;
			while (downCheck) {
				int yTemp = yIdx;

				xTemp = xTemp + 1;

				if (downCheck) {
					totalRiverFound++;
					matrix[xTemp][yIdx] = -1;

				}

				rightCheck = riverFoundAtRight(matrix, xTemp, yTemp);

				while (rightCheck) {
					totalRiverFound++;
					yTemp++;
					matrix[xTemp][yTemp] = -1;

					rightCheck = riverFoundAtRight(matrix, xTemp, yTemp);
					yTemp = yTemp + 1;
				}

				downCheck = riverFoundAtDown(matrix, xTemp, yIdx);

			}

		}
		return totalRiverFound;

	}

	private static boolean riverFoundAtDown(int[][] matrix, int xIdx, int yIdx) {
		if (matrix[xIdx][yIdx] == 1) {
			matrix[xIdx][yIdx] = -1;
		}
		return (xIdx < matrix.length - 1 && matrix[xIdx + 1][yIdx] == 1 ? true : false);
	}

	private static boolean riverFoundAtRight(int[][] matrix, int xIdx, int yIdx) {
		if (matrix[xIdx][yIdx] == 1) {
			matrix[xIdx][yIdx] = -1;
		}
		return (yIdx < matrix[xIdx].length - 1 && matrix[xIdx][yIdx + 1] == 1 ? true : false);
	}

}
