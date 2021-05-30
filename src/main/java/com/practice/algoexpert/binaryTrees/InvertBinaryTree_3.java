package com.practice.algoexpert.binaryTrees;

import java.util.ArrayDeque;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/InvertBinaryTree.png" />
 *
 */
public class InvertBinaryTree_3 {

	public static void main(String[] args) {
		TestBinaryTree tree = new TestBinaryTree(1);

		tree.insert(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }, 0);

		invertBinaryTree(tree);

		InvertedBinaryTree invertedTree = new InvertedBinaryTree(1);

		invertedTree.insert(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }, 0);

	}

	public static void invertBinaryTree(BinaryTree tree) {

		if (tree == null)
			return;

		if (tree.left == null && tree.right == null)
			return;

		BinaryTree tempNode = tree.left;

		tree.left = tree.right;

		tree.right = tempNode;

		invertBinaryTree(tree.left);

		invertBinaryTree(tree.right);

	}

	static class BinaryTree {

		public int value;

		public BinaryTree left;

		public BinaryTree right;

		public BinaryTree(int value) {

			this.value = value;

		}

	}

	static class InvertedBinaryTree {

		public int value;

		public InvertedBinaryTree left;

		public InvertedBinaryTree right;

		public InvertedBinaryTree(int value) {

			this.value = value;

		}

		public void insert(int[] values, int i) {

			if (i >= values.length) {

				return;

			}

			ArrayDeque<InvertedBinaryTree> queue = new ArrayDeque<InvertedBinaryTree>();

			queue.addLast(this);

			while (queue.size() > 0) {

				InvertedBinaryTree current = queue.pollFirst();

				if (current.right == null) {
					break;

				}

				queue.addLast(current.right);

				if (current.left == null) {

					current.left = new InvertedBinaryTree(values[i]);

					break;

				}

				queue.addLast(current.left);

			}

			insert(values, i + 1);

		}

	}

	static class TestBinaryTree extends BinaryTree {

		public TestBinaryTree(int value) {

			super(value);

		}

		public void insert(int[] values, int i) {

			if (i >= values.length) {

				return;

			}

			ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();

			queue.addLast(this);

			while (queue.size() > 0) {

				BinaryTree current = queue.pollFirst();

				if (current.left == null) {

					current.left = new BinaryTree(values[i]);

					break;

				}

				queue.addLast(current.left);

				if (current.right == null) {

					current.right = new BinaryTree(values[i]);

					break;

				}

				queue.addLast(current.right);

			}

			insert(values, i + 1);

		}

	}

}
