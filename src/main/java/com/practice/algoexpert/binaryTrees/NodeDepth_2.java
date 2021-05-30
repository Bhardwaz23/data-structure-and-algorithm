package com.practice.algoexpert.binaryTrees;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/NodeDepth.png" />
 *
 */
public class NodeDepth_2 {

	static int sum = 0;

	public static int nodeDepths(BinaryTree root) {
		Integer depthSum = 0;
		Integer depth = 0;
		int finalValue = nodeDepths(root, depth);
		System.out.println("Printing returned value from method: " + finalValue);
		System.out.println("sum from instance variable : " + sum);
		return depthSum.intValue();

	}

	public static int nodeDepths1(BinaryTree root, int depth) {
		depth = depth + 1;
//	    depthSum = depthSum + depth;
		sum = sum + depth;

		int retVal = depth;
		System.out.println(
				"currentNode Value: " + root.value + " , retVal: " + retVal + " , depth: " + depth + " , sum: " + sum);
		if (root.left != null) {
			retVal += nodeDepths(root.left, depth);
		}

		if (root.right != null) {
			retVal += nodeDepths(root.right, depth);
		}

		return retVal;

	}

	public static int nodeDepths(BinaryTree root, int depth) {

		if (root == null) {
			return 0;
		}
		System.out.println("root value: " + root.value + " , depth: " + depth);
		return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);

	}

	static class BinaryTree {

		int value;

		BinaryTree left;

		BinaryTree right;

		public BinaryTree(int value) {

			this.value = value;

			left = null;

			right = null;

		}

	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);

		root.left = new BinaryTree(2);

		root.left.left = new BinaryTree(4);
		root.left.left.left = new BinaryTree(8);

		root.left.left.right = new BinaryTree(9);

		root.left.right = new BinaryTree(5);

		root.right = new BinaryTree(3);

		root.right.left = new BinaryTree(6);

		root.right.right = new BinaryTree(7);

		nodeDepths(root);
	}

}
