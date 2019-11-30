package com.singking.palindrome;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeTest {

	private Palindrome p = new Palindrome();

	@Test
	public void testScorePalindrome() {
		int expected =4;
		assertEquals("", expected, p.scorePalindrome("put it up"));
	}

	@Test
	public void testNormalise() {
		assertEquals("remove spaces", "liveitup", p.normalise("live it up"));
		assertEquals("ignore special characters", "liveitup", p.normalise("live it up!"));
	}

	@Test
	public void testCheckPalindrome() {
		assertFalse(p.checkPalindrome("god", "dog"));
		assertTrue(p.checkPalindrome("A man, a plan, a canal, Panama", "A man, a plan, a canal, Panama"));
		assertFalse(p.checkPalindrome("A man, a plan, a canal, Panama", "Aman, a plan, a canal, Panama"));
	}

}
