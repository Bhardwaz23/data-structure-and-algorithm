package com.practice.algoexpert.strings;

import java.util.HashMap;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/GenerateDocument.png" />
 *
 */
public class GenerateDocument_4 {

	public static void main(String[] args) {
		String characters = "Bste!hetsi ogEAxpelrt x ";
		String document = "AlgoExpert is the Best!";
		System.out.println(generateDocument(characters, document));

	}

	// O(n + m) time | O(c) space - where n is the number of characters, m is

	// the length of the document, and c is the number of unique characters in the

	// characters string

	public static boolean generateDocument(String characters, String document) {

		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();

		for (int idx = 0; idx < characters.length(); idx++) {

			char character = characters.charAt(idx);

			characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);

		}

		for (int idx = 0; idx < document.length(); idx++) {

			char character = document.charAt(idx);

			if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {

				return false;

			}

			characterCounts.put(character, characterCounts.get(character) - 1);

		}
		return true;

	}
}
