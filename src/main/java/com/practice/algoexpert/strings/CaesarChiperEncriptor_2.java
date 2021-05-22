package com.practice.algoexpert.strings;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/CaesarChiperEncriptor.png" />
 *
 */
public class CaesarChiperEncriptor_2 {

	public static void main(String[] args) {
		System.out.println(caesarCypherEncryptor("mnz", 1));

	}

	// O(n) time | O(n) space

	public static String caesarCypherEncryptor(String str, int key) {

		char[] newLetters = new char[str.length()];

		int newKey = key % 26;

		for (int i = 0; i < str.length(); i++) {

			newLetters[i] = getNewLetter(str.charAt(i), newKey);

		}

		return new String(newLetters);

	}

	public static char getNewLetter(char letter, int key) {

		int newLetterCode = letter + key;

		return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);

	}
	
	
}
