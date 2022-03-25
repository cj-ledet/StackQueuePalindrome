import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * PalindromeTest : a test class for isPalindrome, a method intended to utilize stacks to evaluate if a given
 * string is a palindrome.
 *
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards as it does
 * forwards. Such sequences include "madam," "top spot," or "no lemon, no melon".
 */
public class PalindromeTest {

    /** True test cases which include spaces and symbols */
    private static final String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
    /** False test cases which include spaces and symbols */
    private static final String[] SIMPLE_FALSE = { "AC", "71", "@+" };

    /** True test cases which include spaces */
    private static final String[] WHITE_SPACE_TRUE = { " x ", " t   t  ", " 5 5", " #      # " };
    /** False test cases which include spaces */
    private static final String[] WHITE_SPACE_FALSE = { "m   n  ", "   8  7 ", "  ^      &  "};

    /** Case-sensitive palindromes */
    private static final String[] CASE_SENSITIVE_TRUE = { "ABba", "roTOR", "rAceCaR" };

    /** Complex palindromes which include spaces, symbols, and varied capitalization */
    private static final String[] COMPLEX_TRUE = { "fOO race CAR oof", "AbBa ZaBba", "1 3 3 7  331",
            "N0 LEm0n, n0 Mel0n",
            "sT RJKLEeE R#@ $A$ @# REeEL K  JRT s" };

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    private boolean isPalindrome(String s) {

        // TODO:
        // Implement this method body using your ArrayListStack. Be mindful of your algorithm!
        if (s == null) { throw new IllegalArgumentException("String Cannot Be Null"); }

        ArrayListStack<Character> testStackFront = new ArrayListStack<>();
        ArrayListStack<Character> testStackEnd = new ArrayListStack<>();

        //Remove spaces and capital letters, then send each Char to a Char Array to be split among our two stacks
        char[] charArray = s.toLowerCase().replaceAll(" ", "").toCharArray();

        for (int i = 0, j = charArray.length - 1; i < charArray.length / 2; i++, j--) {
            testStackFront.push(charArray[i]);
            testStackEnd.push(charArray[j]);
        }

        boolean results = true; //Single letter strings are palindromes by default

        if (charArray.length > 1) { //Everything else we test for equality
            for (int i = 0; i < charArray.length / 2; i++)
                results = testStackFront.pop() == testStackEnd.pop();
        }

        return results;
    } // End of method isPalindrome

    //=================================================================
//    private boolean isPalindrome(String s) {
//        if (s == null) {
//            throw new IllegalArgumentException("String must be non-null.");
//        }
//
//        StackInterface<Character> stack = new ArrayListStack<>();
//        char[] chars =  s.toLowerCase().replaceAll(" ", "").toCharArray();
//
//        int i = 0;
//        for (; i < chars.length / 2; i++) {
//            stack.push(chars[i]);
//        }
//        if (chars.length % 2 == 1) {
//            i++;
//        }
//        while (!stack.empty()) {
//            if (stack.pop() != chars[i++]) {
//                return false;
//            }
//        }
//
//        return true;
//
//    }
    //=================================================================


    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(SIMPLE_TRUE[i]));
        }
    }

    @Test
    public void testSimpleFalseCases() {
        for (int i = 0; i < SIMPLE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(SIMPLE_FALSE[i]));
        }
    }

    @Test
    public void testWhitespaceTrueCases() {
        for (int i = 0; i < WHITE_SPACE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(WHITE_SPACE_TRUE[i]));
        }
    }

    @Test
    public void testWhitespaceFalseCases() {
        for (int i = 0; i < WHITE_SPACE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(WHITE_SPACE_FALSE[i]));
        }
    }

    @Test
    public void testCaseSensitivityCases() {
        for (int i = 0; i < CASE_SENSITIVE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(CASE_SENSITIVE_TRUE[i]));
        }
    }

    @Test
    public void testComplexCases() {
        for (int i = 0; i < COMPLEX_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(COMPLEX_TRUE[i]));
        }
    }

} // End of class PalindromeTest