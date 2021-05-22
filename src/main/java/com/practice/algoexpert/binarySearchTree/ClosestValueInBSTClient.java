package com.practice.algoexpert.binarySearchTree;

import com.practice.algoexpert.binarySearchTree.ClosestValueInBST_1.BST;

public class ClosestValueInBSTClient {

	public static void main(String[] args) {
		BST root = new ClosestValueInBST_1.BST(10);

		root.left = new ClosestValueInBST_1.BST(5);

		root.left.left = new ClosestValueInBST_1.BST(2);

		root.left.left.left = new ClosestValueInBST_1.BST(1);

		root.left.right = new ClosestValueInBST_1.BST(5);

		root.right = new ClosestValueInBST_1.BST(15);

		root.right.left = new ClosestValueInBST_1.BST(13);

		root.right.left.right = new ClosestValueInBST_1.BST(14);

		root.right.right = new ClosestValueInBST_1.BST(22);

		int target = 16;
		int actual = ClosestValueInBST_1.findClosestValueInBst(root, target);
		System.out.println("Target was " + target + " and closest is " + actual);
	}

}
