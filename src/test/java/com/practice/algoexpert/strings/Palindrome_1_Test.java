package com.practice.algoexpert.strings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;

public class Palindrome_1_Test {
	
	@Mock
	private Palindrome_1 palindrome_1;
	
	@Test
	public void test() {
		assertTrue(palindrome_1.isPalindrome_Sol2("abcba"));
	}

}
