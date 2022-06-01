package stringapp.longestword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character
 * at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * LC: 720
 */
public class LongestWord {
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        final Set<String> built = new HashSet<>();

        String result = "";
        for (String word : words)
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                result = word.length() > result.length() ? word : result;
                built.add(word);
            }

        return result;
    }
}
