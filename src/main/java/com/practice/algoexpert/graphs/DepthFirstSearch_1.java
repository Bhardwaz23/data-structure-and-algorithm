package com.practice.algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/DepthFirstSearch.png" />
 *
 */
public class DepthFirstSearch_1 {

	public static void main(String[] args) {
		Node graph = new Node("A");

		graph.addChild("B").addChild("C").addChild("D");

		Node nodeB = graph.children.get(0);

		nodeB.addChild("E").addChild("F");

		graph.children.get(2).addChild("G").addChild("H");

		graph.children.get(0).children.get(1).addChild("I").addChild("J");

		graph.children.get(2).children.get(0).addChild("K");

		for (Node n : graph.children) {
			System.out.print(n.name + "\t");
		}
		System.out.println("\n=============");

		List<String> inputArray = new ArrayList<String>();

		graph.depthFirstSearch(inputArray);

		for (String n : inputArray) {
			System.out.print(n + "\t");
		}

	}

	static class Node {

		String name;

		List<Node> children = new ArrayList<Node>();

		public Node(String name) {

			this.name = name;

		}

		// O(v + e) time | O(v) space

		public List<String> depthFirstSearch(List<String> array) {

			array.add(this.name);

			for (int i = 0; i < children.size(); i++) {

				children.get(i).depthFirstSearch(array);

			}

			return array;

		}

		public Node addChild(String name) {

			Node child = new Node(name);

			children.add(child);

			return this;

		}

	}
}
