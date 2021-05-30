package com.practice.algoexpert.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/FindSuccessor.png" />
 *
 */
public class FindSuccessor_5 {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);

		root.left = new BinaryTree(2);

		root.left.parent = root;

		root.right = new BinaryTree(3);

		root.right.parent = root;

		root.left.left = new BinaryTree(4);

		root.left.left.parent = root.left;

		root.left.right = new BinaryTree(5);

		root.left.right.parent = root.left;

		root.left.left.left = new BinaryTree(6);

		root.left.left.left.parent = root.left.left;

		BinaryTree node = root.left.left;

		BinaryTree expected = root.left;

		BinaryTree output = new FindSuccessor_5().findSuccessor(root, node);
		System.out.println("");
		System.out.println("Node sent = " + node.value);
		System.out.println("Expected was : " + expected.value);
		System.out.println("Actual is : " + output.value);
	}

	// This is an input class. Do not edit.

	static class BinaryTree {

		public int value;

		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree parent = null;

		public BinaryTree(int value) {

			this.value = value;

		}

	}

	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		List<BinaryTree> inOrderList = new ArrayList<BinaryTree>();
		prepareInOrderList(tree, node, inOrderList);

		for (int i = 0; i < inOrderList.size()-1; i++) {
			if (inOrderList.get(i).value == node.value) {
				return inOrderList.get(i + 1);
			}
		}
		System.out.println("not found!!");
		return null;

	}

	private void prepareInOrderList(BinaryTree tree, BinaryTree node, List<BinaryTree> inOrderList) {
		if (tree == null) {
			return;
		}

		if (tree.left != null) {
			prepareInOrderList(tree.left, node, inOrderList);

		}

		System.out.print(tree.value + "\t");
		inOrderList.add(tree);

		if (tree.right != null) {
			prepareInOrderList(tree.right, node,inOrderList);

		}

	}
}
