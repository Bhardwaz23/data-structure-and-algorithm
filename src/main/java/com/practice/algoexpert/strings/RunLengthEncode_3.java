package com.practice.algoexpert.strings;

public class RunLengthEncode_3 {

	public static void main(String[] args) {
		System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));

	}

	// O(n) time | O(n) space - where n is the length of the input string

	public static String runLengthEncoding(String string) {

		// The input string is guaranteed to be non-empty,

		// so our first run will be of at least length 1.

		StringBuilder encodedStringCharacters = new StringBuilder();

		int currentRunLength = 1;

		for (int i = 1; i < string.length(); i++) {

			char currentCharacter = string.charAt(i);

			char previousCharacter = string.charAt(i - 1);

			if ((currentCharacter != previousCharacter) || (currentRunLength == 9)) {

				encodedStringCharacters.append(Integer.toString(currentRunLength));

				encodedStringCharacters.append(previousCharacter);
				currentRunLength = 0;

			}

			currentRunLength += 1;

		}

		// Handle the last run.

		encodedStringCharacters.append(Integer.toString(currentRunLength));

		encodedStringCharacters.append(string.charAt(string.length() - 1));

		return encodedStringCharacters.toString();

	}
}
