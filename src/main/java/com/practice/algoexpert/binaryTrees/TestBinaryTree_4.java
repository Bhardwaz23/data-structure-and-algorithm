package com.practice.algoexpert.binaryTrees;

import java.util.ArrayDeque;

class TestBinaryTree_4 extends BinaryTreeDiameter_4.BinaryTree {

	public TestBinaryTree_4(int value) {

		super(value);

	}

	public void insert(int[] values, int i) {
		if (i >= values.length) {

			return;

		}

		ArrayDeque<BinaryTreeDiameter_4.BinaryTree> queue = new ArrayDeque<BinaryTreeDiameter_4.BinaryTree>();

		queue.addLast(this);

		while (queue.size() > 0) {

			BinaryTreeDiameter_4.BinaryTree current = queue.pollFirst();

			if (current.left == null) {

				current.left = new BinaryTreeDiameter_4.BinaryTree(values[i]);

				break;

			}

			queue.addLast(current.left);

			if (current.right == null) {

				current.right = new BinaryTreeDiameter_4.BinaryTree(values[i]);

				break;

			}

			queue.addLast(current.right);

		}

		insert(values, i + 1);

	}

}
