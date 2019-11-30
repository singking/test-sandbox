package com.singking.palindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    private com.singking.palindrome.Palindrome p = new com.singking.palindrome.Palindrome();

    @Test
    public void testScorePalindrome() {
        int expected = 4;
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
