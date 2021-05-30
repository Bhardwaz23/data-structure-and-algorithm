package com.practice.algoexpert.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/HeightBalacedTree.png" />
 *
 */
public class HeightBalacedTree_6 {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);

		root = new BinaryTree(1);

		root.left = new BinaryTree(2);

		root.right = new BinaryTree(3);

		root.left.left = new BinaryTree(4);

		root.left.right = new BinaryTree(5);

		root.right.right = new BinaryTree(6);

		root.left.right.left = new BinaryTree(7);

		root.left.right.right = new BinaryTree(8);

		root.left.right.left.left = new BinaryTree(9);
		root.right.right.left = new BinaryTree(10);

		boolean expected = true;

//		boolean actual = new HeightBalacedTree_6().heightBalancedBinaryTree(root.left);
		boolean actual = new HeightBalacedTree_6().heightBalancedBinaryTreeA(root);
		System.out.println("expected: " + expected);
		System.out.println("actual: " + actual);

	}

	static class BinaryTree {

		public int value;

		public BinaryTree left = null;

		public BinaryTree right = null;

		public BinaryTree(int value) {

			this.value = value;

		}

	}

	public boolean heightBalancedBinaryTree(BinaryTree tree) {
		int depth = 0;
		List<Integer> listToCheckBalancedOrNot = new ArrayList<>();

		distanceOfHeight(tree, depth, listToCheckBalancedOrNot);

		return (listToCheckBalancedOrNot.size() > 0 ? false : true);

	}

	private int distanceOfHeight(BinaryTree tree, int depth, List<Integer> listToCheckBalancedOrNot) {

		if (tree == null)
			return 0;

		int leftHeight = distanceOfHeight(tree.left, depth + 1, listToCheckBalancedOrNot);

		int rightHeight = distanceOfHeight(tree.right, depth + 1, listToCheckBalancedOrNot);

		int distanceOfHeight = Math.abs(leftHeight - rightHeight);
		if (distanceOfHeight > 1) {
			listToCheckBalancedOrNot.add(distanceOfHeight);
		}
		int heightToReturn = Math.max(leftHeight, rightHeight) + 1;
		System.out.println("Node: " + tree.value + " , leftHeight : " + leftHeight + " , rightHeight :" + rightHeight
				+ " , distanceOfHeight :" + distanceOfHeight + " , heightToReturn :" + heightToReturn);
		return heightToReturn;
	}

	// solution of algoexpert

	// O(n) time | O(h) space - where n is the number of nodes in the binary tree

	public boolean heightBalancedBinaryTreeA(BinaryTree tree) {

		TreeInfo treeInfo = getTreeInfo(tree);

		return treeInfo.isBalanced;

	}

	public TreeInfo getTreeInfo(BinaryTree node) {

		if (node == null) {

			return new TreeInfo(true, -1);

		}

		TreeInfo leftSubtreeInfo = getTreeInfo(node.left);

		TreeInfo rightSubtreeInfo = getTreeInfo(node.right);

		boolean isBalanced =

				leftSubtreeInfo.isBalanced

						&& rightSubtreeInfo.isBalanced

						&& Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;

		int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;
		System.out.println("Node: " + node.value + " , isBalanced: " + isBalanced + " , height: " + height);
		if(node.value == 1) {
			System.out.println("DEBUG!!!");
		}

		return new TreeInfo(isBalanced, height);

	}

	static class TreeInfo {

		public boolean isBalanced;

		public int height;

		public TreeInfo(boolean isBalanced, int height) {

			this.isBalanced = isBalanced;

			this.height = height;

		}

	}
}