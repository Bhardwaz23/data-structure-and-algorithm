package com.practice.algoexpert.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/BalancedBracket.png" />
 *
 */
public class BalancedBracket_2 {

	// function to check if brackets are balanced
	static boolean areBracketsBalanced(String expr) {
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if ((x == ')' || x == ']' || x == '}') && stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		System.out.println(stack);

		// Check Empty Stack
		return (stack.isEmpty());
	}

	// Driver code
	public static void main(String[] args) {
		String expr = "(a(";

		// Function call
		if (areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	// O(n) time | O(n) space

	public static boolean balancedBrackets(String str) {

		String openingBrackets = "([{";

		String closingBrackets = ")]}";

		Map<Character, Character> matchingBrackets = new HashMap<Character, Character>();

		matchingBrackets.put(')', '(');

		matchingBrackets.put(']', '[');

		matchingBrackets.put('}', '{');

		List<Character> stack = new ArrayList<Character>();

		for (int i = 0; i < str.length(); i++) {

			char letter = str.charAt(i);

			if (openingBrackets.indexOf(letter) != -1) {

				stack.add(letter);

			} else if (closingBrackets.indexOf(letter) != -1) {

				if (stack.size() == 0) {

					return false;

				}

				if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {

					stack.remove(stack.size() - 1);

				} else {

					return false;

				}

			}

		}

		return stack.size() == 0;

	}

}
