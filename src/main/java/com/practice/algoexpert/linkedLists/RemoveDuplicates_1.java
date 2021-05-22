package com.practice.algoexpert.linkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/RemoveDuplicates.png" />
 *
 */
public class RemoveDuplicates_1 {

	public static void main(String[] args) {
		LinkedList input = new LinkedList(1);
		addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
		LinkedList result = removeDuplicatesFromLinkedList(input);
		List<Integer> resultNodes = getNodesInArray(result);
		for (int i = 0; i < resultNodes.size(); i++) {
			System.out.print(resultNodes.get(i));
			if (i != resultNodes.size() - 1) {
				System.out.print("  ->  ");
			}
		}

	}

	// This is an input class. Do not edit.

	public static class LinkedList {
		public int value;

		public LinkedList next;

		public LinkedList(int value) {

			this.value = value;

			this.next = null;

		}

	}

	// O(n) time | O(1) space - where n is the number of nodes in the Linked List

	public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

		LinkedList currentNode = linkedList;

		while (currentNode != null) {

			LinkedList nextDistinctNode = currentNode.next;

			while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {

				nextDistinctNode = nextDistinctNode.next;

			}
			currentNode.next = nextDistinctNode;

			currentNode = nextDistinctNode;

		}
		return linkedList;

	}

	public static LinkedList addMany(LinkedList ll, List<Integer> values) {

		LinkedList current = ll;

		while (current.next != null) {

			current = current.next;

		}

		for (int value : values) {
			current.next = new LinkedList(value);

			current = current.next;

		}

		return ll;

	}

	public static List<Integer> getNodesInArray(LinkedList ll) {

		List<Integer> nodes = new ArrayList<Integer>();

		LinkedList current = ll;

		while (current != null) {

			nodes.add(current.value);

			current = current.next;

		}

		return nodes;

	}

}