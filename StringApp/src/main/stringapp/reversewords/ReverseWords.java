package stringapp.reversewords;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * LC: 557
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder currentWord = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != ' ')
                currentWord.insert(0, currentChar);

            if (currentChar == ' ' || i == (s.length() - 1)) {
                result.append(currentWord).append(" ");
                currentWord.setLength(0);
            }
        }

        return result.toString().trim();
    }

    public static String reverseWordsStringBuilder(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words)
            result.append(reverseWord(word)).append(" ");
        return result.toString().trim();
    }

    public static String reverseWordsStream(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> reverseWord(word).toString())
                .collect(Collectors.joining(" "));
    }

    private static StringBuilder reverseWord(String word) {
        return new StringBuilder(word).reverse();
    }
}
