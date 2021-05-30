package com.practice.algoexpert.binaryTrees;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/BinaryTreeDiameter.png" />
 *
 */
public class BinaryTreeDiameter_4 {
	static int largest = 0;

	public static void main(String[] args) {
		TestBinaryTree_4 input = new TestBinaryTree_4(1);

		input.insert(new int[] { 2, 3, 4, 5, 6, 7 }, 0);

		new BinaryTreeDiameter_4().binaryTreeDiameter(input);
		System.out.println(largest);

	}

	// This is an input class. Do not edit.

	static class BinaryTree {

		public int value;

		public BinaryTree left = null;

		public BinaryTree right = null;

		public BinaryTree(int value) {

			this.value = value;

		}

	}

	public int binaryTreeDiameter(BinaryTree tree) {

		return binaryTreeDiameterHealper(tree, 0);

	}

	public int binaryTreeDiameterHealper(BinaryTree tree, int depth) {

		if (tree == null) {
			return 0;
		}
//		System.out.println("tree.value: " + tree.value + " , and diameter is : " + diameter);

		int largestDiameter = 0;
		depth = depth + 1;
		int leftDepth = binaryTreeDiameterHealper(tree.left, depth);
		int rightDepth = binaryTreeDiameterHealper(tree.right, depth);

		largestDiameter = leftDepth + rightDepth;// - 2 * depth;
		largest = (largest > largestDiameter ? largest : largestDiameter);
		System.out.println("tree.value: " + tree.value + " , \t leftDepth : " + leftDepth + " , \t rightDepth : "
				+ rightDepth + " , \t largestDiameter :" + largestDiameter + ",\t largest :" + largest);
//		System.out.println("diameter :"+diameter);
//		return depth;
//		return largestDiameter + 1;
		return (leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1);

	}
}
