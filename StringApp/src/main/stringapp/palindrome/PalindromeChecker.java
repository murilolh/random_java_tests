package stringapp.palindrome;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * LC: 125
 */
public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);

            if (!Character.isLetterOrDigit(leftChar))
                leftIndex++;
            else if (!Character.isLetterOrDigit(rightChar))
                rightIndex--;
            else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                    return false;
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }
}
